package com.murali.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.murali.model.Authorities;
import com.murali.model.Cart;
import com.murali.model.Customer;
import com.murali.model.Users;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void saveCustomer(Customer customer) {
			Users users=customer.getUsers();
			users.setEnabled(true);
			Authorities authorities=new Authorities();
			authorities.setUsername(users.getUserName());
			authorities.setRole("ROLE_USER");
			
			Session session=sessionFactory.openSession();
			session.save(authorities);
			
			Cart cart=new Cart();
			cart.setCustomer(customer); 
			customer.setCart(cart);
			session.save(customer);
			session.flush();
			session.close();
			

	}

	public List<Customer> getCustomers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer");
		List<Customer> customers=query.list();
		session.close();
		return customers;
	}

}

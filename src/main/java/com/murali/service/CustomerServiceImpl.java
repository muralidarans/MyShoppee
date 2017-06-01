package com.murali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.dao.CustomerDao;
import com.murali.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 customerDao.saveCustomer(customer);

	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

}

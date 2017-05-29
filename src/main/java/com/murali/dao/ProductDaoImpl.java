package com.murali.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.murali.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product) {
		Session session=sessionFactory.openSession();
		System.out.println("PRODUCT ID BEFORE INSERTION " + product.getProductID());
		session.save(product);
		System.out.println("PRODUCT ID AFTER INSERTION " + product.getProductID());
		session.flush();
		session.close();
	}public ArrayList<Product> viewAllProducts() {
			// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		//System.out.println("PRODUCT ID BEFORE INSERTION " + product.getProductID());
		List list = session.createCriteria(Product.class).list();
		//System.out.println("PRODUCT ID AFTER INSERTION " + product.getProductID());
		session.flush();
		session.close();
		
		return (ArrayList<Product>) list;
		}
	public void deleteProduct(int productID){
		
		System.out.println("in deleteProduct");
		Session session=sessionFactory.openSession();
		System.out.println("before query");
		 Product product=(Product)session.load(Product.class, productID); //persistent
		System.out.println("before delete");
		 session.delete(product);
		 System.out.println("after delete");
		 System.out.println("end of deleteProduct");
		session.flush();
		session.close();
	}
	public Product getProductById(int productID){
		
		System.out.println("in getProductById");
		Session session=sessionFactory.openSession();
		System.out.println("before query");
		 Product product=(Product)session.get(Product.class, productID); //persistent
		
		 System.out.println("after query");
		 System.out.println("end of getProductById");
		session.flush();
		session.close();
		return product;
	}
}
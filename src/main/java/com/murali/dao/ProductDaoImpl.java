package com.murali.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.murali.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdateProduct(Product product) {
		Session session=sessionFactory.openSession();
		System.out.println("PRODUCT ID BEFORE INSERTION " + product.getProductID());
		session.saveOrUpdate(product);
		System.out.println("PRODUCT ID AFTER INSERTION " + product.getProductID());
		session.flush();
		session.close();
	}
	
	public void addProduct(Product product) {
		Session session=sessionFactory.openSession();
		System.out.println("PRODUCT ID BEFORE INSERTION " + product.getProductID());
		session.save(product);
		System.out.println("PRODUCT ID AFTER INSERTION " + product.getProductID());
		session.flush();
		session.close();
	}public ArrayList<Product> viewAllProducts() {
		Session session=sessionFactory.openSession();
		List list = session.createCriteria(Product.class).list();
		
		ArrayList<Product> prdList = (ArrayList<Product>) list;
		for(Product pd : prdList){
			setEncodedImage(pd);
		}
		session.flush();
		session.close();
		
		return prdList;
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
		 setEncodedImage(product);
		 System.out.println("after query");
		 System.out.println("end of getProductById");
		session.flush();
		session.close();
		return product;
	}
	public LobCreator getLobCreator(){
		Session session=sessionFactory.openSession();
		return Hibernate.getLobCreator(session);
	}
	public void setEncodedImage(Product product){
		try{
			int length = (int)product.getImageContent().length();
			byte[] imageArray  = product.getImageContent().getBytes(1, length);
			product.setEncodedImageString(Base64.getEncoder().encodeToString(imageArray));
			
		}catch(Exception e){
			System.out.println("failed to encodee image th" + e.getMessage());
		}
	}
}
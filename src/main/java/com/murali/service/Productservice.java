package com.murali.service;

import java.util.ArrayList;

import org.hibernate.engine.jdbc.LobCreator;

import com.murali.model.Product;

public interface Productservice {
	void addproduct(Product Product);
	ArrayList<Product> viewAllProducts();
	void deleteProduct(int productId);
	Product getProductById(int productId);
	void saveOrUpdateProduct(Product product);
	 LobCreator getLobCreator();
}

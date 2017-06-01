package com.murali.dao;

import java.util.ArrayList;

import org.hibernate.engine.jdbc.LobCreator;

import com.murali.model.Product;

public interface ProductDao {
	void addProduct(Product product);
	ArrayList<Product> viewAllProducts();
	void deleteProduct(int productID);
	Product getProductById(int productId);
	void saveOrUpdateProduct(Product product);
	 LobCreator getLobCreator();

}

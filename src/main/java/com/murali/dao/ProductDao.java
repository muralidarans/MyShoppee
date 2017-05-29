package com.murali.dao;

import java.util.ArrayList;

import com.murali.model.Product;

public interface ProductDao {
	void addProduct(Product product);
	ArrayList<Product> viewAllProducts();
	void deleteProduct(int productID);
	Product getProductById(int productId);


}

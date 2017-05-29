package com.murali.service;

import java.util.ArrayList;

import com.murali.model.Product;

public interface Productservice {
	void addproduct(Product Product);
	ArrayList<Product> viewAllProducts();
	void deleteProduct(int productId);
	Product getProductById(int productId);

}

package com.murali.service;

import java.util.ArrayList;

import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.dao.ProductDao;
import com.murali.model.Product;
@Service
public class ProductServiceImpl implements Productservice {
	@Autowired
	private ProductDao productDao;
	
	public void saveOrUpdateProduct(Product product) {
		   productDao.saveOrUpdateProduct(product);
			
		}
	public void addproduct(Product product) {
		   productDao.addProduct(product);
			
		}
	
	 public ArrayList<Product> viewAllProducts() {
		ArrayList<Product> list= productDao.viewAllProducts();
		return list;
	}
	 public void deleteProduct(int productId){
		 productDao.deleteProduct(productId);
	 }
	 public Product getProductById(int productId){
		 Product product = productDao.getProductById(productId);
		 return product;

	 }
	 public LobCreator getLobCreator(){
		 return productDao.getLobCreator();
	 }


}

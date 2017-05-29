package com.murali.model;

import javax.management.remote.TargetedNotification;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodcutID;
	@NotEmpty(message="Product name is mandatory")
	private String productName;
	@NotEmpty(message="Manufacturer details is mandatory")
	private String manufacturer;
	@Min(value=100,message="Minimum price should be 100")
	private double price;
	@Min(value=10,message="unit in stock minimum value is 10")
	private int unitInStock;
	@NotEmpty(message="Description is mandatory")
	private String description;
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="cid")
	private Category category;
	@Transient
	private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getProdcutID() {
		return prodcutID;
	}
	public void setProdcutID(int prodcutID) {
		this.prodcutID = prodcutID;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getProductID() {
		return prodcutID;
	}
	public void setProductID(int productID) {
		this.prodcutID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	
}

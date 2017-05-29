package com.murali.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.murali.model.Category;
import com.murali.model.Product;
import com.murali.service.CategoryService;
import com.murali.service.Productservice;

@Controller
public class Productcontrollers {
	@Autowired
	private Productservice productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/admin/product/productform")
	public String getProductForm(Model model){
		
		model.addAttribute("productObj",new Product());
		List<Category> categoryDetails=categoryService.getAllCategories();
		model.addAttribute("categorydetails",categoryDetails);
		return "addProduct";
	}
	

@RequestMapping("/admin/product/addProduct")
	public String addProduct(@Valid @ModelAttribute(name="productObj") Product product,BindingResult result){
		if(result.hasErrors())
			return "addproduct";
	productService.addproduct(product);
	return "redirect:/all/product/productlist";
	}

@RequestMapping("/all/product/productlist")
public ModelAndView getProductList(){
	ArrayList<Product> a = productService.viewAllProducts();
	
	return new ModelAndView("ViewAllaproduct", "productList",a );
}
@RequestMapping("/all/product/viewProduct/{id}")
public String viewProduct(@PathVariable int id,Model model){
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	return "viewProduct";
}
@RequestMapping("/all/product/deleteproduct/{id}")
public String deleteProduct(@PathVariable int id){
	System.out.println("in delete controller" );
	productService.deleteProduct(id);
	
	return "redirect:/all/product/productlist";
	
}

}


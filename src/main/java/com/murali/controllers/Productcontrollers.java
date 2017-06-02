package com.murali.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.murali.model.Category;
import com.murali.model.Product;
import com.murali.service.CategoryService;
import com.murali.service.Productservice;

@SessionAttributes("categorydetails")
@Controller
public class Productcontrollers {

	
	private static final Logger logger = Logger.getLogger(Productcontrollers.class);

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
	
	@RequestMapping("/admin/product/editproduct/{id}")
	public String editProduct(@PathVariable int id,Model model){
		Product product=productService.getProductById(id);
		model.addAttribute("productObj",product);
		List<Category> categoryDetails=categoryService.getAllCategories();
		model.addAttribute("categorydetails",categoryDetails);
		return "addProduct";
	}

@RequestMapping("/admin/product/addProduct")
	public String addProduct(@Valid @ModelAttribute(name="productObj") Product product, BindingResult result){
		if(result.hasErrors()){
			return "addProduct";
		}
		System.out.println("After validation");
		
		MultipartFile image=product.getImage();
		if(image!=null && !image.isEmpty()){
			
			if(logger.isDebugEnabled()){
				logger.debug("File name"+image.getName());
			}
			System.out.println("File name"+image.getName());
		System.out.println("File name"+image.getContentType());
		try {
			product.setImageContent(productService.getLobCreator().createBlob(image.getInputStream(),image.getSize()));
			
			product.setContentType(image.getContentType());
			product.setFileName(String.valueOf(product.getProdcutID()));
		} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			logger.debug("File no file uploaded");
		}
		productService.saveOrUpdateProduct(product);
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
	String encodedImage="";
	
	return "viewProduct";
}
@RequestMapping("/all/product/deleteproduct/{id}")
public String deleteProduct(@PathVariable int id){
	System.out.println("in delete controller" );
	productService.deleteProduct(id);
	
	return "redirect:/all/product/productlist";
	
}
@RequestMapping("/all/product/productsByCategory")
public String getProductsByCategory(@RequestParam(name="searchCondition") String searchCondition,
		Model model,HttpSession session){
	session.setAttribute("categories",categoryService.getAllCategories());
	List<Product> products=productService.viewAllProducts();
	//Assigning list of products to model attribute products
	model.addAttribute("products",products);
	model.addAttribute("searchCondition",searchCondition);
	return "productlist";
}


}


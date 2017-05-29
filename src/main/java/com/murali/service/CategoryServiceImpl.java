package com.murali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.dao.CategoryDao;
import com.murali.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
}
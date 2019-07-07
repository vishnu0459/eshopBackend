package com.vishnu.WishBackend.dao;

import java.util.List;

import com.vishnu.WishBackend.model.Category;

public interface CategoryDao {

	
	 boolean saveCategory(Category category);
	 boolean editCategory(Category category);   
	  boolean deleteCategory(Category category);
	    
	  Category getCategory(int categoryId);
	    
	  List<Category>  getCategoryList();
}

package com.vishnu.WishBackend.dao;

import java.util.List;

import com.vishnu.WishBackend.model.Category;
import com.vishnu.WishBackend.model.Product;


public interface ProductDao {

	 boolean saveProduct(Product product);
	 boolean editProduct(Product product);
	  boolean deleteProduct(Product product);
	    
	  Product getProduct(int productId);
	    
	  List<Product>  getProductrList();
	  List<Product>  getProductList(Category category);
}

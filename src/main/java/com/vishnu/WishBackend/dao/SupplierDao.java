package com.vishnu.WishBackend.dao;

import java.util.List;


import com.vishnu.WishBackend.model.Supplier;

public interface SupplierDao {
	
	
	 boolean saveSupplier(Supplier supplier);
	 boolean editSupplier(Supplier supplier); 
	  boolean deleteSupplier(Supplier supplier);
	    
	  Supplier getSupplier(int supplierId);
	    
	  List<Supplier>  getSupplierList();

}

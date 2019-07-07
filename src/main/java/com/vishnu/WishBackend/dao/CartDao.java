package com.vishnu.WishBackend.dao;

import java.util.List;

import com.vishnu.WishBackend.model.Cart;
import com.vishnu.WishBackend.model.Product;

public interface CartDao {
	
	boolean saveCart(Cart cart);
	 boolean editCart(Cart cart);
	    boolean deleteCart(Cart cart);
	    
	    Cart getCart(int cartId);
	    
	   List<Cart>    getCartList(String username);

}

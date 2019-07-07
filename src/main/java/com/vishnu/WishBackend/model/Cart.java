package com.vishnu.WishBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cart {

	
	@Id
	private int cartId;
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
	private String productDescription;
	@Column
	private int productPrice;
	@Column
	private String productSupplier;
	@Column
	private int quantity;
	@Column
	private int cartTotalPrice;
	@Column
	private String userName;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductSupplier() {
		return productSupplier;
	}
	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(int cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

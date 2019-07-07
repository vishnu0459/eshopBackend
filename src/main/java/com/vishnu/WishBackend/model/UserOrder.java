package com.vishnu.WishBackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userOrderId;
	@Column
	int grandTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserRegister user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	 private ShippingAddress shippingAddress;
	
	
	@Column
	private	Date date;

	
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public int getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	public UserRegister getUser() {
		return user;
	}
	public void setUser(UserRegister user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

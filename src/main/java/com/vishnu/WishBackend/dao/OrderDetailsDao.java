package com.vishnu.WishBackend.dao;

import java.util.List;

import com.vishnu.WishBackend.model.UserOrder;

public interface OrderDetailsDao {
	boolean saveOrderDetails(UserOrder userOrder);
	 
	
	
	List<UserOrder> getMyOrders(String userName);
}

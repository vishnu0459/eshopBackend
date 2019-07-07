package com.vishnu.WishBackend.dao;

import com.vishnu.WishBackend.model.UserRegister;

public interface UserDao {

	   public boolean addUser(UserRegister user);
	    public boolean checkLogin(UserRegister user);
	    public UserRegister getUser(String email);
	    boolean editUser(UserRegister user);
}

package com.niit.SayhiBackend.dao;


import java.util.ArrayList;

import com.niit.SayhiBackend.model.User;

import antlr.collections.List;

public interface UserDAO {
	 ArrayList<User> getAllUser();

	boolean saveUser(User user);
}
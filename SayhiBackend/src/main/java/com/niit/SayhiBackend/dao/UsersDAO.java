package com.niit.SayhiBackend.dao;


import java.util.ArrayList;

import com.niit.SayhiBackend.model.Users;

import antlr.collections.List;

public interface UsersDAO {
	 ArrayList<Users> getAllUser();

	boolean saveUser(Users user);
}
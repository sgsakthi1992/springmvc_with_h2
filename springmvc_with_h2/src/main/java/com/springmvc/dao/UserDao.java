package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Users;

public interface UserDao {

	public List<Users> getUsers();

	public void save(Users user);
	
}

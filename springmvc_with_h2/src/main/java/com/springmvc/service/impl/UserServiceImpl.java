package com.springmvc.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.springmvc.dao.UserDao;
import com.springmvc.model.Users;
import com.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<Users> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void uploadUsers(MultipartFile file) {

		try {
			String content = new String(file.getBytes());
			Gson gson = new Gson();
			Users[] users = gson.fromJson(content, Users[].class);
			for(Users user : users) {
				userDao.save(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	

}

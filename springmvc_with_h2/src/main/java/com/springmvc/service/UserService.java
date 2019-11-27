package com.springmvc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.model.Users;

public interface UserService {
	
	public List<Users> getUsers();

	public void uploadUsers(MultipartFile file);

}

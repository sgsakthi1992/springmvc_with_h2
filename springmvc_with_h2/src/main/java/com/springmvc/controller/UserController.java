package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/getUsers")
	public String getUsers(ModelMap modelMap) {
		modelMap.put("usersList", userService.getUsers());
		return "UsersList";
	}

}

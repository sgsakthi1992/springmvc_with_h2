package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/getUsers")
	public ModelAndView getUsers() {
		ModelAndView mav = new ModelAndView("UsersList");
		mav.addObject("usersList", userService.getUsers());
		return mav;
	}
	
	@RequestMapping(value = "uploadFile", method = RequestMethod.GET)
	public String uploadFileView() {
		return "UploadFile";
	}
	
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		userService.uploadUsers(file);
		
		return "index";
	}
}

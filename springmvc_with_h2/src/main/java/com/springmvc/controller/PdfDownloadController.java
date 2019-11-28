package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.springmvc.model.Users;
import com.springmvc.service.UserService;

@Controller
public class PdfDownloadController extends AbstractController{
	
	@Autowired
	UserService userService;
	
	@Override
	@RequestMapping("downloadPdf")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Users> usersList = userService.getUsers();
		return new ModelAndView("PdfPhoneDirectory", "usersList", usersList);
	}
}

package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	public AdminController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to FORWARD the clnt to view layer
	@GetMapping("/add_new_tut")
	public String showNewTutForm()
	{
		System.out.println("in show new tut form");
		return "/admin/add_new_tut";//AVN : /WEB-INF/views/admin/add_new_tut.jsp
	}

}

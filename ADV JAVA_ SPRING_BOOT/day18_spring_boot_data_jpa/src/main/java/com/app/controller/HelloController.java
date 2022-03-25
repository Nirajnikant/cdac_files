package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String showHomePage(Model map)
	{
		System.out.println("in show hm page");
		map.addAttribute("time_stamp", new Date());
		return "/index";
	}

}

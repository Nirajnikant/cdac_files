package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory
//Request handling controller = handler , singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method : to show index page
	@RequestMapping("/")  //can intercept ANY (get/post/put/delete) HTTP request
	public String showIndexPage()
	{
		System.out.println("in show index page");
		return "/index";//  /index : logical view name(forward) ---> AVN : /WEB-INF/views/index.jsp
	}
	//add req handling method : to show welcome content
	@RequestMapping("/test")
	public String showWelcomePage()
	{
		System.out.println("in show welcome page");
		return "/hello";//AVN : /WEB-INF/views/hello.jsp
	}
	
	
	
	

}

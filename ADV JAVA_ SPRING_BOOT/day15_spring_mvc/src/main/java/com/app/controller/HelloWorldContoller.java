package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory : to tell Spring Container this class contains methods request
			// handling logic, a.k.a. Handler
// singleton and eager
public class HelloWorldContoller {
	public HelloWorldContoller() {
		System.out.println("in constructor of  "+ getClass());
	}
	
	@PostConstruct
	public void init123() {
		System.out.println("in init");
	}
	// add request handling mehod to test mvc flow 
	@RequestMapping("/hello") // mandatory to tell SC : method will perform request handling
	public String sayHello1() {
		System.out.println("in say hello 1");
		return "/welcome";// RequestHandlingController snds back "logical view Name" to D.S.
	}
	// add request handling method to show index page
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in show home page");
		return "/index";// AVN : /WEB-INF/view/index.jsp
	}
}

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ITopicService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//dependency : topic service i/f
	@Autowired
	private ITopicService topicService;
	
	public CustomerController() {
		System.out.println("in ctor of " + getClass());
	}
	// add req handling method to show all topics , method-GET (since it's redirect
	// request)
	@GetMapping("/topics")
	public String showAllTopics(Model map)
	{
		System.out.println("in get all topics "+map);
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/customer/topics";//V.R --> AVN : /WEB-INF/views/customer/topics.jsp
	}

}

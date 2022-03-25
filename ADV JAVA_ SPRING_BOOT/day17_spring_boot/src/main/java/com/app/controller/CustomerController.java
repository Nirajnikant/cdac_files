package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ITopicDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// dependency : TopicDao i/f
	@Autowired
	private ITopicDao topicDao;

	public CustomerController() {
		System.out.println("in constructor of " + getClass());
	}

	// add req handling method to FORWARD the clnt to view layer
	@GetMapping("/topics")
	public String showAllTopics(Model map) {
		System.out.println("in get all topics" + map);
		map.addAttribute("topic_list", topicDao.getAllTopics());
		return "/customer/topics"; // Logical View Name
									// View Resolver :/ WEB-INF/view/customer/topics.jsp
	}
}

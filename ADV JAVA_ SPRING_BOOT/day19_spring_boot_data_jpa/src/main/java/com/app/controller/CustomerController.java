package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// dependency : topic service i/f
	@Autowired
	private ITopicService topicService;

	@Autowired
	private ITutorialService tutorialService;

	public CustomerController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show all topics , method-GET (since it's redirect
	// request)
	@GetMapping("/topics")
	public String showAllTopics(Model map) {
		System.out.println("in get all topics " + map);
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/customer/topics";// V.R --> AVN : /WEB-INF/views/customer/topics.jsp
	}

	// add req handling method to show all tuts under selected topic
	@GetMapping("/tutorials")
	public String showTutorialsByTopic(@RequestParam int topicId, Model map) {
		System.out.println("in show tuts " + topicId);
		// invoke service layer method for getting all tut names for the chosen topic
		map.addAttribute("tut_names", tutorialService.getTutorialNames(topicId));
		return "/customer/tutorials";//sent from handler--> D.S --> V.R --> AVN :/WEB-INF/views/customer/tutorial_details/customer/tutrials.jsp
	}
	//add req handling method to show updated tut contents
	@GetMapping("/tutorial_details")
	public String showTutDetails(@RequestParam(name="tut_name") String tutName,Model map)
	{
		System.out.println("in show tut details "+tutName);
		//invoke tut service 's method to get updated tut contents
		map.addAttribute("tut_details", tutorialService.getUpdatedTutorialContents(tutName));
		return "/customer/tutorial_details";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
	}

}

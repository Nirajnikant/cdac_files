package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IProjectDao;

@Controller
public class ProjectController {
	@Autowired
	private IProjectDao projectDao;

	public ProjectController() {
		System.out.println("in constructor of  " + getClass());
	}

	@PostConstruct
	public void init123() {
		System.out.println("in init");
	}

	@RequestMapping("/")
	public String showHomePage(Model map) {
		System.out.println("in project home page");
		try {
			List<String> projects = projectDao.getAllProjectTitles();
			map.addAttribute("projectList", projects);
			return "/projects/project"; // Actual View Name :: /WEB-INF/view/project.jsp
		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);
			map.addAttribute("message", "Invalid Login, Please retry!!!!");
			return "/projects/project"; // Actual View Name :: /WEB-INF/view/project.jsp
		}
	}
}

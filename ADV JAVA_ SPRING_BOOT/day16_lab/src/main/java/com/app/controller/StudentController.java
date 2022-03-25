package com.app.controller;


import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IStudentDao;
import com.app.pojos.Project;
import com.app.pojos.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
	private IStudentDao stud;
	
	public StudentController() {
		System.out.println("in constructor of  " + getClass());
	}

	@PostConstruct
	public void init() {
		System.out.println("in init");
	}
	
	@RequestMapping("/details")
	public String getStudentDetails(@RequestParam String titleName,Model map) {
		System.out.println("in process form "+titleName+" "+map);
		try {
			Set<Student> user = stud.getCourseStudentDetails(titleName);
			//=> valid login , store authenticated user details : in request scope (i.e model attribute)
			map.addAttribute("user_details", user);
			map.addAttribute("message","Login Successful");
			//authorization
			if(user.getRole().equals("ADMIN"))
				return "redirect:/admin/add_new_tut";//AVN : /WEB-INF/views/admin/add_new_tut.jsp
			//=> customer login
			return "redirect:/customer/topics";//AVN : /WEB-INF/views/customer/topics.jsp
			//SC invokes : response.sendRedirect(response.encodeRedirectURL("/customer/topics"))
			
		} catch (RuntimeException e) {
			System.out.println("err in process login form "+e);
			map.addAttribute("message", "Invalid Login , Pls retry!!!!!!!!!!!!!");
			return "/user/login";//AVN :  /WEB-INF/views/user/login.jsp
		}
	}
}

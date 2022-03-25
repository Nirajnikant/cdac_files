package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	//dependency : service layer i/f
	@Autowired
	private IUserService userService;
	
	public UserController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method to process form
	//@RequestParam : annotation to bind req params to req handling method args
	//Reco to match : req param names to method args names.
	//o.w : will have to supply additionally "name"
	//eg :@RequestParam(name = "password") String pass
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, 
			@RequestParam String password,Model map) {
		System.out.println("in process login form "+email+" "+password+" "+map);
		//handler invokes service layer method for exec B.L
		try {
			User user = userService.authenticateUser(email, password);
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

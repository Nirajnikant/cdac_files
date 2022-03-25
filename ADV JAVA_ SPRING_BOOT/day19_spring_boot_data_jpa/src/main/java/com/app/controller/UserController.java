package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency : service layer i/f
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
	// @RequestParam : annotation to bind req params to req handling method args
	// Reco to match : req param names to method args names.
	// o.w : will have to supply additionally "name"
	// eg :@RequestParam(name = "password") String pass
	// SC invokes : for @RequestParam String email,
	// String email=request.getParamter("email");
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		System.out.println("in process login form " + email + " " + password + " " + map);
		// handler invokes service layer method for exec B.L
		try {
			User user = userService.authenticateUser(email, password);
			// => valid login , store authenticated user details : in request scope (i.e
			// model attribute)
			session.setAttribute("user_details", user);// store it under session scope (till logout)
			flashMap.addFlashAttribute("message", "Login Successful");// store it under flash scope (till immediate next
																		// request)
			// authorization
			if (user.getRole().equals("ADMIN"))
				return "redirect:/admin/add_new_tut";// AVN : /WEB-INF/views/admin/add_new_tut.jsp
			// => customer login
			return "redirect:/customer/topics";// Handler rets redirect view name to D.S
			// SC invokes :
			// response.sendRedirect(response.encodeRedirectURL("/customer/topics"))
			// WC -- temp redirect resp
			// clnt browser : NEXT request :
			// http://host:port/spring_mvc_boot/customer/topics , method =GET

		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);
			map.addAttribute("message", "Invalid Login , Pls retry!!!!!!!!!!!!!");// request scope
			return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
		}

	}

	// add req handling method to log out user
	@GetMapping("/logout")
	public String logOutUser(HttpSession session,HttpServletRequest request,HttpServletResponse resp,Model map) {
		System.out.println("in log out");
		//copy user details from session ---> model map
		map.addAttribute("details", session.getAttribute("user_details"));
		// Tell WC thro SC , to invalidate the session (i.e delete the entry in the
		// outer map : refer to HttpSession internal diag
		session.invalidate();
		//set refresh header of HTTP resp
		resp.setHeader("refresh", "5;url="+request.getContextPath());// value of hdr 5;url=/spring-mvc-boot
		
		return "/user/logout";// AVN : /WEB-INF/views/user/logout.jsp
	}

}

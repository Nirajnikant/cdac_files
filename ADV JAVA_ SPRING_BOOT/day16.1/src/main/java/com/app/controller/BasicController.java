package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // MANDATORY
@RequestMapping("/basic") // OPTIONAL BUT reco : for separation
public class BasicController {
	public BasicController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method to generate dyn contents
	@GetMapping("/test1") // @GetMapping = @RequestMapping : Request method = GET
	public ModelAndView showDynContents() {
		System.out.println("in show dyn contents");
		// o.s.w.s.ModelAndView(String logViewName,String modelAttrName,Object
		// modelAttrVal)
		return new ModelAndView("/basic/test1", "server_ts", LocalDateTime.now());
		// Handler rets MnV to D.S
		// D.S sends log view name : /basic/test1 to V.R
		// V.R rets : /WEB-INF/views/basic/test1.jsp
		// D.S chks --are there any model attrs --- YES -- adds them in req scope
		// --forward

	}

	// add req handling method to test model map
	@GetMapping("/test2")
	public String testModelMap(Model modelMap) // D.I => Handler method is telling SC to supply EMPTY map
	{
		System.out.println("in test model map " + modelMap);// {}
		// populating the map with results : done by prog
		// API : o.s.ui.Model : i/f
		// Method Model addAttribute(String name,Object value)
		modelMap.addAttribute("server_ts", LocalDateTime.now()).addAttribute("num_list", Arrays.asList(10, 20, 30, 40));
		System.out.println(modelMap);// {k1=v1,k2=v2}
		return "/basic/test2";
		// Handler rets explicitly : LVN , BUT : implicitly reted : map of model attrs
		// D.S sends log view name : /basic/test2 to V.R
		// V.R rets : /WEB-INF/views/basic/test2.jsp
		// D.S chks --are there any model attrs --- YES -- adds them in req scope
		// --forward
	}

}

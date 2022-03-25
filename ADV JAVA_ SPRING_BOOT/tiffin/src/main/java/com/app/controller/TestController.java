package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Mandatory annotation = @Controller at the cls level + @ResponseBody anno over
				// ret type of req handling methods
@RequestMapping("/dummy")
public class TestController {
	@GetMapping
	public String testMe() {
		System.out.println("in test me");
		return "Hello from back-end @" + LocalDateTime.now();
	}

}

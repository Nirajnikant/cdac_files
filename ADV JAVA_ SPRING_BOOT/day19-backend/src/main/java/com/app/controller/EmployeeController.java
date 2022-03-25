package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	// dep : service layer i/f
	@Autowired
	private IEmployeeService empService;

	// add a REST API end point to send list of emps to the front end.
	@GetMapping
	public List<Employee> fetchAllEmps() {
		System.out.println("in fetch all emps");
		return empService.getAllEmployees();
	}

}

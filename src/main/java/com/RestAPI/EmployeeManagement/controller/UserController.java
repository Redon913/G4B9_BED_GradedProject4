package com.RestAPI.EmployeeManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.EmployeeManagement.entity.Employee;
import com.RestAPI.EmployeeManagement.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@PostMapping("/new/")
	public ResponseEntity<Employee> sortAllEmployee(@RequestBody User newCreds, @RequestParam String role){
		System.out.println(newCreds);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}

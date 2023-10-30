package com.RestAPI.EmployeeManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.EmployeeManagement.entity.Role;
import com.RestAPI.EmployeeManagement.service.RoleService;


@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	private RoleService roleService;
	
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	@GetMapping
	public ResponseEntity<List<Role>> findAllEmployee(){
		return new ResponseEntity<>(roleService.FindAllRoles(), HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<Role> addEmployee(@Validated @RequestBody Role role) {
		return new ResponseEntity<>(roleService.AddNewRole(role), HttpStatus.OK);
	}
}

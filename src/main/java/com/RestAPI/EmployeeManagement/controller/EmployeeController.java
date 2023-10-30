package com.RestAPI.EmployeeManagement.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.RestAPI.EmployeeManagement.entity.Employee;
import com.RestAPI.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@RequestMapping
	public ResponseEntity<List<Employee>> findAllEmployee(){
		return new ResponseEntity<>(employeeService.FindAllEmployee(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Long Id){
		return new ResponseEntity<>(employeeService.FindEmployeeById(Id), HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable(value = "id") Long Id) {
		employeeService.DeleteEmployee(Id);
	}
	
	@RequestMapping("/search/{firstname}")
	public ResponseEntity<List<Employee>> searchEmployeeByFirstName(@PathVariable(value = "firstname") String fname){
		return new ResponseEntity<>(employeeService.SearchEmployeeByFirstName(fname), HttpStatus.OK);
	}
	
	@RequestMapping("/sort")
	public ResponseEntity<List<Employee>> sortAllEmployee(@RequestParam String sortOrder){
		System.out.println(sortOrder);
		if(sortOrder.toLowerCase().contentEquals("asc") || sortOrder.toLowerCase().contentEquals("desc")) {
			return new ResponseEntity<>(employeeService.SortAllEmployee(sortOrder), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/new")
	public ResponseEntity<Employee> addEmployee(@Validated @RequestBody Employee emp) {
		return new ResponseEntity<>(employeeService.AddNewEmployee(emp), HttpStatus.OK);
	}
	
	@RequestMapping("/edit")
	public ResponseEntity<Employee> editEmployee(@Validated @RequestBody Employee emp) {
		Employee e = employeeService.FindEmployeeById(emp.getId());
		e.setId(emp.getId());
		e.setFirstName(emp.getFirstName());
		e.setLastName(emp.getLastName());
		e.setEmail(emp.getEmail());
		return new ResponseEntity<>(employeeService.EditExistingEmployee(emp), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/accessdenied")
	public ResponseEntity<String> accessDenied() {
		return new ResponseEntity<>("Access Denied", HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping("/error")
	public ResponseEntity<String> errorhandeling(){
		return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
	}
	

}

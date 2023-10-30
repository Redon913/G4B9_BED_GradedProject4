package com.RestAPI.EmployeeManagement.service;

import java.util.List;

import com.RestAPI.EmployeeManagement.entity.Employee;

public interface EmployeeService {
	List<Employee> FindAllEmployee();
	
	Employee FindEmployeeById(Long Id);
	
	Employee AddNewEmployee(Employee Emp);

	Employee EditExistingEmployee(Employee Emp);

	void DeleteEmployee(Long id);
	
	List<Employee> SearchEmployeeByFirstName(String fname);
	
	List<Employee> SortAllEmployee(String sortOrder);
}

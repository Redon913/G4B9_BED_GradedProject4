package com.RestAPI.EmployeeManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RestAPI.EmployeeManagement.entity.Employee;
import com.RestAPI.EmployeeManagement.repository.EmployeeRepository;
import com.RestAPI.EmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> FindAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee FindEmployeeById(Long Id) {
		return employeeRepository.findById(Id).get();
	}

	@Override
	public Employee AddNewEmployee(Employee Emp) {
		return employeeRepository.save(Emp);
	}

	@Override
	public Employee EditExistingEmployee(Employee Emp) {
		return employeeRepository.save(Emp);
		
	}
	
	@Override
	public void DeleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> SearchEmployeeByFirstName(String fname) {
		return employeeRepository.searchEmployeeByFirstName(fname);
	}

	@Override
	public List<Employee> SortAllEmployee(String sortOrder) {
		if(sortOrder.toLowerCase().contentEquals("asc"))
			return employeeRepository.sortAllEmployeeAsc();
		else
			return employeeRepository.sortAllEmployeeDesc();
			
	}
	
	
}

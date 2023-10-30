package com.RestAPI.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RestAPI.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("select e from Employee e where e.firstName = :firstName or :firstName is null")
    List<Employee> searchEmployeeByFirstName(@Param("firstName") String fname);
	
	@Query("select u from Employee u order by u.firstName asc")
    List<Employee> sortAllEmployeeAsc();
	
	@Query("select u from Employee u order by u.firstName desc")
    List<Employee> sortAllEmployeeDesc();

}

package com.RestAPI.EmployeeManagement.service;

import java.util.List;

import com.RestAPI.EmployeeManagement.entity.Role;

public interface RoleService {

	List<Role> FindAllRoles();
	
	Role AddNewRole(Role role);
}

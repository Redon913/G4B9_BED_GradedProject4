package com.RestAPI.EmployeeManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RestAPI.EmployeeManagement.entity.Role;
import com.RestAPI.EmployeeManagement.repository.RoleRepository;
import com.RestAPI.EmployeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> FindAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role AddNewRole(Role role) {
		return roleRepository.save(role);
	}

}

package com.RestAPI.EmployeeManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.RestAPI.EmployeeManagement.entity.User;
import com.RestAPI.EmployeeManagement.repository.UserRepository;
import com.RestAPI.EmployeeManagement.security.UserSecurity;



public class UserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new UserSecurity(user);
	    }
	    
	    public User addUser(User user) {
	    	return userRepository.save(user);
	    }

}

package com.learning.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.demo.entity.UserInfo;
import com.learning.demo.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired(required=true)
	UserDetailsRepository repository;
	
	@Override
	public UserInfo findUserInfoById(String id) {
		
		return this.repository.findUserInfoById(id);
	}

	  

}

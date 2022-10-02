package com.learning.demo.service;

import org.springframework.stereotype.Service;

import com.learning.demo.entity.UserInfo;


public interface UserDetailsService {

	UserInfo findUserInfoById(String firstName);
	  

}

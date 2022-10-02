package com.learning.demo.repository;

import org.springframework.stereotype.Repository;

import com.learning.demo.entity.UserInfo;

@Repository
public interface UserDetailsRepository {

	UserInfo findUserInfoById(String id);
  
}

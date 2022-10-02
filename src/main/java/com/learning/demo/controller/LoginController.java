package com.learning.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.demo.entity.UserInfo;
import com.learning.demo.service.UserDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class LoginController extends ResponseEntityExceptionHandler {

	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping(value = "/validateUserDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> validateUser(@RequestBody UserInfo userDetails) {

		String message = "";

		System.out.println("userDetails : " + userDetails.toString());

		UserInfo userInfo = null;

		if (userDetails != null) {
			userInfo = userDetailsService.findUserInfoById(userDetails.getMail());
		}

		if (userInfo == null) {
			message = "Create New user";
		} else if (userDetails.getPassword() != null && userDetails.getPassword().equals(userInfo.getPassword())) {
			System.out.println("userInfo : " + userInfo.toString());
			message = "Valid User";
		} else {
			System.out.println("userInfo : " + userInfo.toString());
			message = "Invalid User";
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}

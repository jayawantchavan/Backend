package com.learning.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="USER_INFO")
public class UserInfo {

	@Id
	@Email
	@Column(name="ID")
	String mail;

	@Column(name="PASSWORD")
	String password;

	@Column(name="ROLE")
	String role;
		
	public UserInfo() {
	}

	public UserInfo(String mail, String password, String role) {
		super();
		this.mail = mail;
		this.password = password;
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserCredential [mail=" + mail + ", password=" + password + ", role=" + role + "]";
	}

}
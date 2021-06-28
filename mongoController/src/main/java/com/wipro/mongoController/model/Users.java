package com.wipro.mongoController.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userlist")
public class Users {
	
	@Id
	private String username;
	private String email;
	private String password;
	
	
	
	public Users() {
		super();
	}
	public Users(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
}

package com.example.demo.entities;

public class Credential {
	String user_id;
	String password;
	public Credential(String user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

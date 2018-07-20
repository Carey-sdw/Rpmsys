package com.rpm.entity;


public class LoginUser {
	private String username;
	private String userpwd;
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getuserpwd() {
		return userpwd;
	}
	public void setuserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public LoginUser(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}
	public LoginUser() {
	}
	

}

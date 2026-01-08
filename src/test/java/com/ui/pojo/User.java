package com.ui.pojo;

public class User {
	private String emailAddress;
	private String password;
	
	public User(String emailAdress, String password) {
		super();
		this.emailAddress = emailAdress;
		this.password = password;
	}
	public String getEmailAdress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	

}

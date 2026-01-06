package com.ui.pojo;

public class User {
	private String emailAdress;
	private String password;
	
	public User(String emailAdress, String password) {
		super();
		this.emailAdress = emailAdress;
		this.password = password;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailAdress=" + emailAdress + ", password=" + password + "]";
	}
	
	

}

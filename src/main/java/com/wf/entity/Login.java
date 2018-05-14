package com.wf.entity;

public class Login {
	private Long id;
	private String userName;
	private String password;
	private String encode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", password=" + password + ", encode=" + encode + "]";
	}
	
	
	
}

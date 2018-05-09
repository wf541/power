package com.wf.entity;
/*
 * id number(7) primary key,
       user_name varchar2(64),
       mail varchar2(64),
       phone number(7),
       password varchar2(64),
       encode varchar2(64),
       readagain char(1)
       
       String  数字
       int  越界
 */
public class Reg {
	private Long id;
	private String userName;
	private String mail;
	private int phone;
	private String password;
	private String encode;
	private Boolean readagain;
	
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
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
	public Boolean getReadagain() {
		return readagain;
	}
	public void setReadagain(Boolean readagain) {
		this.readagain = readagain;
	}
	@Override
	public String toString() {
		return "Reg [id=" + id + ", userName=" + userName + ", mail=" + mail + ", phone=" + phone + ", password="
				+ password + ", encode=" + encode + ", readagain=" + readagain + "]";
	}
	
	
}

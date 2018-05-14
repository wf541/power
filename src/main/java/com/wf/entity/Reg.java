package com.wf.entity;
/*
 * id number(7) primary key,
       user_name varchar2(64),
        relname varchar2(64),
       sex char(1),
       mail varchar2(64),
       phone number(11),
       password varchar2(64),
       encode varchar2(64),
        idencity varchar2(64),
       infor varchar2(64),
       postCode number(25),
       area varchar2(64),
       address varchar2(64)
       
       String  数字
       int  越界
 */
public class Reg {
	private Long id;
	private String userName;
	
	private String mail;
	private Long phone;
	private String password;
	private String encode;
	
	private Long postCode;
	private String area;
	private String address;
	
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
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	public Long getPhone() {
		return phone;
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
	
	
	public Long getPostCode() {
		return postCode;
	}
	public void setPostCode(Long postCode) {
		this.postCode = postCode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Reg [id=" + id + ", userName=" + userName + ", mail=" + mail + ", phone=" + phone + ", password="
				+ password + ", encode=" + encode + ", postCode=" + postCode + ", area=" + area + ", address=" + address
				+ "]";
	}
	
	
}

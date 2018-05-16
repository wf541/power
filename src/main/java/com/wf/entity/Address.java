package com.wf.entity;
/*
 *  id number(7) primary key,
        relname varchar2(64),
       phone number(11),
       postCode number(25),
       area varchar2(64),
       address varchar2(64)
 */
public class Address {
	private Long id;
	private String arelname;
	private Long aphone;
	private Long postCode;
	private String area;
	private String address;
	private Long regId;
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getArelname() {
		return arelname;
	}
	public void setArelname(String arelname) {
		this.arelname = arelname;
	}
	public Long getAphone() {
		return aphone;
	}
	public void setAphone(Long aphone) {
		this.aphone = aphone;
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
	
	public Long getRegId() {
		return regId;
	}
	public Long setRegId(Long regId) {
		return this.regId = regId;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(Long id, String arelname, Long aphone, Long postCode, String area, String address, Long regId,
			Login login) {
		super();
		this.id = id;
		this.arelname = arelname;
		this.aphone = aphone;
		this.postCode = postCode;
		this.area = area;
		this.address = address;
		this.regId = regId;
		this.login = login;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", arelname=" + arelname + ", aphone=" + aphone + ", postCode=" + postCode
				+ ", area=" + area + ", address=" + address + ", regId=" + regId + ", login=" + login + "]";
	}
	
	
}

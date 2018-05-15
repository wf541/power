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
	private String relname;
	private Long phone;
	private Long postCode;
	private String area;
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRelname() {
		return relname;
	}
	public void setRelname(String relname) {
		this.relname = relname;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
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
		return "Address [id=" + id + ", relname=" + relname + ", phone=" + phone + ", postCode=" + postCode + ", area="
				+ area + ", address=" + address + "]";
	}
	
	
}

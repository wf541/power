package com.wf.entity;

public class Vip {
	private Long id;
	private String relname;
	private char sex;
	private String mail;
	private String idencity;
	private String infor;
	
	
	
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getIdencity() {
		return idencity;
	}
	public void setIdencity(String idencity) {
		this.idencity = idencity;
	}
	public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Vip [id=" + id + ", relname=" + relname + ", sex=" + sex + ", mail=" + mail + ", idencity=" + idencity
				+ ", infor=" + infor + "]";
	}
	
}

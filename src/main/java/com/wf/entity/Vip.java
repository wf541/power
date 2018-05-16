package com.wf.entity;

public class Vip {
	private Long id;
	private String relname;
	private char sex;
	private String mail;
	private String idencity;
	private String infor;
	
	private Login login;
	
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
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Vip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vip(Long id, String relname, char sex, String mail, String idencity, String infor) {
		super();
		this.id = id;
		this.relname = relname;
		this.sex = sex;
		this.mail = mail;
		this.idencity = idencity;
		this.infor = infor;
	}
	
	@Override
	public String toString() {
		return "Vip [id=" + id + ", relname=" + relname + ", sex=" + sex + ", mail=" + mail + ", idencity=" + idencity
				+ ", infor=" + infor + "]";
	}
	
}

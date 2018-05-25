package com.wf.entity;

/*
 *   id number(7) primary key,
       reg_id number(7) references power_reg(id),
      address_id number(7) references power_address(id),
      state varchar2(25)
 */

public class Order {
	private Long id;
	private String state;
	
	
	private Long regId;
	private Long addressId;
	
//	对一
	
	private Reg reg;
	private Address address;
	
	private Car car;
	private Commodity commodity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getRegId() {
		return regId;
	}
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	
	
	
	public Reg getReg() {
		return reg;
	}
	public void setReg(Reg reg) {
		this.reg = reg;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	
	public Order() {
		super();
	}
	
	
	public Order(Long id, String state, Long regId, Long addressId, Reg reg, Address address, Car car,
			Commodity commodity) {
		super();
		this.id = id;
		this.state = state;
		this.regId = regId;
		this.addressId = addressId;
		this.reg = reg;
		this.address = address;
		this.car = car;
		this.commodity = commodity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + ", regId=" + regId + ", addressId=" + addressId + ", reg=" + reg
				+ ", address=" + address + ", car=" + car + ", commodity=" + commodity + "]";
	}
	
}

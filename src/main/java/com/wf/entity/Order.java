package com.wf.entity;

import java.util.List;

/*
 *   id number(7) primary key,
       reg_id number(7) references power_reg(id),
      address_id number(7) references power_address(id),
      state varchar2(25)
 */
/*
 * id number(7) primary key,
       order_id number(7) references power_order(id),
      commodity_id number(7) references power_commoditys(id),
      counts number(25)
 */
public class Order {
	private Long id;
	private String state;

//	对一
	private Reg reg;
	private Address address;
	
//	对一
	private Commodity commodity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", reg=" + reg + ", address=" + address + ", state=" + state + ", commodity="
				+ commodity + "]";
	}

	public Order(Long id, Reg reg, Address address, String state, Commodity commodity) {
		super();
		this.id = id;
		this.reg = reg;
		this.address = address;
		this.state = state;
		this.commodity = commodity;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

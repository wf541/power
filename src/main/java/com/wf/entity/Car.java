package com.wf.entity;
/*
 *    id number(7) primary key,
       reg_id number(7) references power_reg(id),
      commodity_id number(7) references power_commoditys(id),
      counts number(25)
 */
public class Car {
	private Long id;
	private Long regId;
	private Long commodityId;
	private Long counts;
	
	private Commodity commodity;
	
	
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRegId() {
		return regId;
	}
	public void setRegId(Long regId) {
		this.regId = regId;
	}
	public Long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	public Long getCounts() {
		return counts;
	}
	public void setCounts(Long counts) {
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", regId=" + regId + ", commodityId=" + commodityId + ", counts=" + counts
				+ ", commodity=" + commodity + "]";
	}
	
	public Car(Long id, Long regId, Long commodityId, Long counts, Commodity commodity) {
		super();
		this.id = id;
		this.regId = regId;
		this.commodityId = commodityId;
		this.counts = counts;
		this.commodity = commodity;
	}
	public Car() {
		super();
	}
	
	
}

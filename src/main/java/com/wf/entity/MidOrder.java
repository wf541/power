package com.wf.entity;
/*
 * id number(7) primary key,
       order_id number(7) references power_order(id),
      commodity_id number(7) references power_commoditys(id),
      counts number(25)
 */
public class MidOrder {
	private Long id;
	private Long orderId;
	private Long commodityId;
	private Long counts;
	
//对一
	
	private Order order;
	private Commodity commodity;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	public MidOrder() {
		super();
	}
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	
	
	
	public MidOrder(Long id, Long orderId, Long commodityId, Long counts, Order order, Commodity commodity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.commodityId = commodityId;
		this.counts = counts;
		this.order = order;
		this.commodity = commodity;
	}
	@Override
	public String toString() {
		return "MidOrder [id=" + id + ", orderId=" + orderId + ", commodityId=" + commodityId + ", counts=" + counts
				+ ", order=" + order + ", commodity=" + commodity + "]";
	}
	
}

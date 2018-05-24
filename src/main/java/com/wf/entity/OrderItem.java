package com.wf.entity;

public class OrderItem {
	private Long id;
	private Long orderId;
	private Long commodityId;
	private Long counts;
	
	private Order order;
	private Address address;
	private Car car;
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
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	
	public OrderItem(Long id, Long orderId, Long commodityId, Long counts, Order order, Address address, Car car,
			Commodity commodity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.commodityId = commodityId;
		this.counts = counts;
		this.order = order;
		this.address = address;
		this.car = car;
		this.commodity = commodity;
	}
	public OrderItem() {
		super();
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", commodityId=" + commodityId + ", counts=" + counts
				+ ", order=" + order + ", address=" + address + ", car=" + car + ", commodity=" + commodity + "]";
	}
	
	
}

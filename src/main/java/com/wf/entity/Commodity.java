package com.wf.entity;
/*商品详情列表类
 * 名称，描述，价格，库存
 *  id number(7) primary key,
       name varchar2(64),
        describe varchar2(64),
       price number(7,2),
       stock number(7),
       counts number(25)
 */
public class Commodity {
	private Long id;
	private String name;
	private String describe;
	private double price;
	private Long stock;
	private Long counts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
	public Long getCounts() {
		return counts;
	}
	public void setCounts(Long counts) {
		this.counts = counts;
	}
	
	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commodity(Long id, String name, String describe, double price, Long stock, Long counts) {
		super();
		this.id = id;
		this.name = name;
		this.describe = describe;
		this.price = price;
		this.stock = stock;
		this.counts = counts;
	}
	public Commodity(double price, Long counts, String name) {
		
		this.price = price;
		this.name= name;
		this.counts = counts;
		
	}
/*	@Override
	public String toString() {
		double pc = this.price*this.counts;
		return "￥"+pc;
	}*/
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", describe=" + describe + ", price=" + price + ", stock="
				+ stock + ", counts=" + counts + "]";
	}
	
}

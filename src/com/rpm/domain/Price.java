package com.rpm.domain;

public class Price {
	
	private Long cost_id;
	private Double price;
	private String pricename;
	private String type_t;
	public Price(Long cost_id, Double price, String pricename, String type_t) {
		this.cost_id = cost_id;
		this.price = price;
		this.pricename = pricename;
		this.type_t = type_t;
	}
	public String getType_t() {
		return type_t;
	}
	public void setType_t(String type_t) {
		this.type_t = type_t;
	}
	public Long getCost_id() {
		return cost_id;
	}
	public void setCost_id(Long cost_id) {
		this.cost_id = cost_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPricename() {
		return pricename;
	}
	public void setPricename(String pricename) {
		this.pricename = pricename;
	}
	@Override
	public String toString() {
		return "Price [cost_id=" + cost_id + ", price=" + price + ", pricename=" + pricename + ", type_t=" + type_t
				+ "]";
	}
	
	public Price() {
	}
	
}

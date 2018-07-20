package com.rpm.domain;
/**
 * 费用
 * @author cdw
 */
public class Property {
	private Long tds;
	private int tvalue;//抄表值
	private String ttime;
	private int price;//单价
	private int ttype;
	private User user;
	public Long getTds() {
		return tds;
	}
	public void setTds(Long tds) {
		this.tds = tds;
	}
	public int getTvalue() {
		return tvalue;
	}
	public void setTvalue(int tvalue) {
		this.tvalue = tvalue;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Property [tds=" + tds + ", tvalue=" + tvalue + ", ttime=" + ttime + ", price=" + price + ", ttype="
				+ ttype + ", user=" + user + "]";
	}
	public Property(Long tds, int tvalue, String ttime, int price, int ttype, User user) {
		this.tds = tds;
		this.tvalue = tvalue;
		this.ttime = ttime;
		this.price = price;
		this.ttype = ttype;
		this.user = user;
	}
	public Property() {
	}
	
	
	
	
}

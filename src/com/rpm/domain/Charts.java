package com.rpm.domain;

public class Charts {
	private String tablename;
	private Long tds;
	private Double tvalue;//本月度量
	private String ttime;//时间
	private Double tvalues;//度量
	private Long user_id;
	private Long ttype;//表单
	private Double price;
	private Long house_id;
	private Long type_t;
	
	public Charts(String tablename, Long tds, Double tvalue, String ttime, Double tvalues, Long user_id, Long ttype,
			Double price, Long house_id, Long type_t) {
		this.tablename = tablename;
		this.tds = tds;
		if(tvalue==null) {
			this.tvalue = tvalue;
		}else {
			this.tvalue = (double)Math.round(tvalue*100)/100;
		}
		this.ttime = ttime;
		if(tvalues==null) {
			this.tvalues = tvalues;
		}else {
			this.tvalues =(double)Math.round(tvalues*100)/100;
		}
		this.user_id = user_id;
		this.ttype = ttype;
		if(price==null) {
			this.price = price;
		}else {
			this.price = (double)Math.round(price*100)/100;
		}
		this.house_id = house_id;
		this.type_t = type_t;
	}
	public Long getType_t() {
		return type_t;
	}
	public void setType_t(Long type_t) {
		this.type_t = type_t;
	}
	public Charts() {
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public Long getTds() {
		return tds;
	}
	public void setTds(Long tds) {
		this.tds = tds;
	}
	public Double getTvalue() {
		return tvalue;
	}
	public void setTvalue(Double tvalue) {
		if(tvalue==null) {
			this.tvalue = tvalue;
		}else {
			this.tvalue = (double)Math.round(tvalue*100)/100;
		}
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public Double getTvalues() {
		return tvalues;
	}
	public void setTvalues(Double tvalues) {
		if(tvalues==null) {
			this.tvalues = tvalues;
		}else {
			this.tvalues = (double)Math.round(tvalues*100)/100;
		}
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getTtype() {
		return ttype;
	}
	public void setTtype(Long ttype) {
		this.ttype = ttype;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		if(price==null) {
			this.price = price;
		}else {
			this.price = price*100/100;
		}
	}
	public Long getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}
	@Override
	public String toString() {
		return "Charts [tablename=" + tablename + ", tds=" + tds + ", tvalue=" + tvalue + ", ttime=" + ttime
				+ ", tvalues=" + tvalues + ", user_id=" + user_id + ", ttype=" + ttype + ", price=" + price
				+ ", house_id=" + house_id + ", type_t=" + type_t + "]";
	}
	
}

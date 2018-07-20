package com.rpm.entity;

public class Chart {
	private String pricename;
	private Long tds;
	private Double tvalue;//上月度量
	private String ttime;//时间
	private Double tvalues;//度量
	private Long user_id;
	private Long ttype;//表单
	private Double price;
	private Long house_id;
	private String username;
	private String house_name;
	private Double prices;//总价
	private Long type_t;
	
	public String getPricename() {
		return pricename;
	}

	public void setPricename(String pricename) {
		this.pricename = pricename;
	}

	public Chart(Long tds, Double tvalue, String ttime, Double tvalues, Long user_id, Long ttype, Double price,
			Long house_id, String username, String house_name, Double prices, Long type_t) {
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
			this.tvalues = (double)Math.round(tvalues*100)/100;
		}
		this.user_id = user_id;
		this.ttype = ttype;
		if(price==null) {
			this.price = price;
		}else {
			this.price = (double)Math.round(price*100)/100;
		}
		this.house_id = house_id;
		this.username = username;
		this.house_name = house_name;
		if(prices==null) {
			this.prices = prices;
		}else {
			this.prices =(double)Math.round(prices*100)/100;
		}
		this.type_t = type_t;
	}

	public Long getType_t() {
		return type_t;
	}

	public void setType_t(Long type_t) {
		this.type_t = type_t;
	}

	public Chart() {
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
			this.price = (double)Math.round(price*100)/100;
		}
	}

	public Long getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHouse_name() {
		return house_name;
	}

	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}

	public Double getPrices() {
		return prices;
	}

	public void setPrices(Double prices) {
		if(prices==null) {
			this.prices = prices;
		}else {
			this.prices =(double)Math.round(prices*100)/100;
		}
	}

	@Override
	public String toString() {
		return "Chart [pricename=" + pricename + ", tds=" + tds + ", tvalue=" + tvalue + ", ttime=" + ttime
				+ ", tvalues=" + tvalues + ", user_id=" + user_id + ", ttype=" + ttype + ", price=" + price
				+ ", house_id=" + house_id + ", username=" + username + ", house_name=" + house_name + ", prices="
				+ prices + ", type_t=" + type_t + "]";
	}


	
}

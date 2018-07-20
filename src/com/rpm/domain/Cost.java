package com.rpm.domain;

public class Cost {
	private Long cost_id;
	private double water_bill;
	private double electric_bill;
	private double gas_bill;
	private double property_bill;
	private double other;
	private double ttype;
	private double allcost;
	private Long user_id;
	private Long house_id;
	private String username;
	private String housename;
	private String time_s;
	public Long getCost_id() {
		return cost_id;
	}
	public void setCost_id(Long cost_id) {
		this.cost_id = cost_id;
	}
	public double getWater_bill() {
		return water_bill;
	}
	public void setWater_bill(double water_bill) {
		this.water_bill = water_bill;
	}
	public double getElectric_bill() {
		return electric_bill;
	}
	public void setElectric_bill(double electric_bill) {
		this.electric_bill = electric_bill;
	}
	public double getGas_bill() {
		return gas_bill;
	}
	public void setGas_bill(double gas_bill) {
		this.gas_bill = gas_bill;
	}
	public double getProperty_bill() {
		return property_bill;
	}
	public void setProperty_bill(double property_bill) {
		this.property_bill = property_bill;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public double getTtype() {
		return ttype;
	}
	public void setTtype(double ttype) {
		this.ttype = ttype;
	}
	public double getAllcost() {
		return allcost;
	}
	public void setAllcost(double allcost) {
		this.allcost = allcost;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	public String getTime_s() {
		return time_s;
	}
	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}
	@Override
	public String toString() {
		return "Cost [cost_id=" + cost_id + ", water_bill=" + water_bill + ", electric_bill=" + electric_bill
				+ ", gas_bill=" + gas_bill + ", property_bill=" + property_bill + ", other=" + other + ", ttype="
				+ ttype + ", allcost=" + allcost + ", user_id=" + user_id + ", house_id=" + house_id + ", username="
				+ username + ", housename=" + housename + ", time_s=" + time_s + "]";
	}
	public Cost(Long cost_id, double water_bill, double electric_bill, double gas_bill, double property_bill, double other, double ttype,
			double allcost, Long user_id, Long house_id, String username, String housename, String time_s) {
		this.cost_id = cost_id;
		this.water_bill = water_bill;
		this.electric_bill = electric_bill;
		this.gas_bill = gas_bill;
		this.property_bill = property_bill;
		this.other = other;
		this.ttype = ttype;
		this.allcost = allcost;
		this.user_id = user_id;
		this.house_id = house_id;
		this.username = username;
		this.housename = housename;
		this.time_s = time_s;
	}
	public Cost() {
	}
	
	
}

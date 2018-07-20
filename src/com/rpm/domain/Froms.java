package com.rpm.domain;

public class Froms {
	private Long from_id;
	private int water_bill;
	private int electric_bill;
	private int gas_bill;
	private int property_bill;
	private int other;
	private String time_s;
	private Long user_id;
	private int ttype;
	private String housename;
	public Long getFrom_id() {
		return from_id;
	}
	public void setFrom_id(Long from_id) {
		this.from_id = from_id;
	}
	public int getWater_bill() {
		return water_bill;
	}
	public void setWater_bill(int water_bill) {
		this.water_bill = water_bill;
	}
	public int getElectric_bill() {
		return electric_bill;
	}
	public void setElectric_bill(int electric_bill) {
		this.electric_bill = electric_bill;
	}
	public int getGas_bill() {
		return gas_bill;
	}
	public void setGas_bill(int gas_bill) {
		this.gas_bill = gas_bill;
	}
	public int getProperty_bill() {
		return property_bill;
	}
	public void setProperty_bill(int property_bill) {
		this.property_bill = property_bill;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
	}
	public String getTime_s() {
		return time_s;
	}
	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	@Override
	public String toString() {
		return "Froms [from_id=" + from_id + ", water_bill=" + water_bill + ", electric_bill=" + electric_bill
				+ ", gas_bill=" + gas_bill + ", property_bill=" + property_bill + ", other=" + other + ", time_s="
				+ time_s + ", user_id=" + user_id + ", ttype=" + ttype + ", housename=" + housename + "]";
	}
	public Froms(Long from_id, int water_bill, int electric_bill, int gas_bill, int property_bill, int other,
			String time_s, Long user_id, int ttype, String housename) {
		this.from_id = from_id;
		this.water_bill = water_bill;
		this.electric_bill = electric_bill;
		this.gas_bill = gas_bill;
		this.property_bill = property_bill;
		this.other = other;
		this.time_s = time_s;
		this.user_id = user_id;
		this.ttype = ttype;
		this.housename = housename;
	}
	public Froms() {
	}
	
	
}

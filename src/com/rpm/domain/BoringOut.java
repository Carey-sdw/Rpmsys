package com.rpm.domain;

public class BoringOut {
	private Long boring_id;
	private String boringname;
	private String handle;
	private Long number_s;
	private Long bnumber;
	private Long enumber;
	private String time_s;
	private Long borings_id ;
	private String purpose;
	private String type_t;
	private int price;
	
	public BoringOut(Long boring_id, String boringname, String handle, Long number_s, Long bnumber, Long enumber,
			String time_s, Long borings_id, String purpose, String type_t, int price) {
		this.boring_id = boring_id;
		this.boringname = boringname;
		this.handle = handle;
		this.number_s = number_s;
		this.bnumber = bnumber;
		this.enumber = enumber;
		this.time_s = time_s;
		this.borings_id = borings_id;
		this.purpose = purpose;
		this.type_t = type_t;
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getType_t() {
		return type_t;
	}
	public void setType_t(String type_t) {
		this.type_t = type_t;
	}

	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Long getBoring_id() {
		return boring_id;
	}
	public void setBoring_id(Long boring_id) {
		this.boring_id = boring_id;
	}
	public String getBoringname() {
		return boringname;
	}
	public void setBoringname(String boringname) {
		this.boringname = boringname;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Long getNumber_s() {
		return number_s;
	}
	public void setNumber_s(Long number_s) {
		this.number_s = number_s;
	}
	public Long getBnumber() {
		return bnumber;
	}
	public void setBnumber(Long bnumber) {
		this.bnumber = bnumber;
	}
	public Long getEnumber() {
		return enumber;
	}
	public void setEnumber(Long enumber) {
		this.enumber = enumber;
	}
	public String getTime_s() {
		return time_s;
	}
	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}
	public Long getBorings_id() {
		return borings_id;
	}
	public void setBorings_id(Long borings_id) {
		this.borings_id = borings_id;
	}
	@Override
	public String toString() {
		return "BoringOut [boring_id=" + boring_id + ", boringname=" + boringname + ", handle=" + handle + ", number_s="
				+ number_s + ", bnumber=" + bnumber + ", enumber=" + enumber + ", time_s=" + time_s + ", borings_id="
				+ borings_id + ", purpose=" + purpose + ", type_t=" + type_t + ", price=" + price + "]";
	}
	public BoringOut() {
	}
	
}

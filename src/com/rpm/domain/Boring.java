package com.rpm.domain;

public class Boring {
	private Long boring_id;
	private String boringname;
	private String source_s;
	private String telephone;
	private String handle;
	private Long number_s;
	private int price;
	private String time_s;
	private Long borings_id ;
	private String type_t;
	private Long bnumber;
	
	public Boring(Long boring_id, String boringname, String source_s, String telephone, String handle, Long number_s,
			int price, String time_s, Long borings_id, String type_t, Long bnumber) {
		this.boring_id = boring_id;
		this.boringname = boringname;
		this.source_s = source_s;
		this.telephone = telephone;
		this.handle = handle;
		this.number_s = number_s;
		this.price = price;
		this.time_s = time_s;
		this.borings_id = borings_id;
		this.type_t = type_t;
		this.bnumber = bnumber;
	}
	public Long getBnumber() {
		return bnumber;
	}
	public void setBnumber(Long bnumber) {
		this.bnumber = bnumber;
	}
	
	public String getType_t() {
		return type_t;
	}
	public void setType_t(String type_t) {
		this.type_t = type_t;
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
	public String getSource_s() {
		return source_s;
	}
	public void setSource_s(String source_s) {
		this.source_s = source_s;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public Boring() {
	}
	@Override
	public String toString() {
		return "Boring [boring_id=" + boring_id + ", boringname=" + boringname + ", source_s=" + source_s
				+ ", telephone=" + telephone + ", handle=" + handle + ", number_s=" + number_s + ", price=" + price
				+ ", time_s=" + time_s + ", borings_id=" + borings_id + ", type_t=" + type_t + ", bnumber=" + bnumber
				+ "]";
	}

}

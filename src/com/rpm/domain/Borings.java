package com.rpm.domain;

public class Borings {
	private Long borings_id;
	private String boringname;
	private Long number_s;
	private Long number_e;
	private String type_t;
	public Long getBorings_id() {
		return borings_id;
	}
	public void setBorings_id(Long borings_id) {
		this.borings_id = borings_id;
	}
	public String getBoringname() {
		return boringname;
	}
	public void setBoringname(String boringname) {
		this.boringname = boringname;
	}
	public Long getNumber_s() {
		return number_s;
	}
	public void setNumber_s(Long number_s) {
		this.number_s = number_s;
	}
	public Long getNumber_e() {
		return number_e;
	}
	public void setNumber_e(Long number_e) {
		this.number_e = number_e;
	}
	public String getType_t() {
		return type_t;
	}
	public void setType_t(String type_t) {
		this.type_t = type_t;
	}
	@Override
	public String toString() {
		return "Borings [borings_id=" + borings_id + ", boringname=" + boringname + ", number_s=" + number_s
				+ ", number_e=" + number_e + ", type_t=" + type_t + "]";
	}
	public Borings(Long borings_id, String boringname, Long number_s, Long number_e, String type_t) {
		this.borings_id = borings_id;
		this.boringname = boringname;
		this.number_s = number_s;
		this.number_e = number_e;
		this.type_t = type_t;
	}
	public Borings() {
	}
	
}

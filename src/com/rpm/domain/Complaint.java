package com.rpm.domain;

public class Complaint {
	private Long complaint_id; 
	private String describe; 
	private Long type_t; 
	private String housename; 
	private String username; 
	private Handle handle; 
	private String time_s;
	private String time_e;
	private Long telephone;
	public Long getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(Long complaint_id) {
		this.complaint_id = complaint_id;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Long getType_t() {
		return type_t;
	}
	public void setType_t(Long type_t) {
		this.type_t = type_t;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Handle getHandle() {
		return handle;
	}
	public void setHandle(Handle handle) {
		this.handle = handle;
	}
	public String getTime_s() {
		return time_s;
	}
	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}
	public String getTime_e() {
		return time_e;
	}
	public void setTime_e(String time_e) {
		this.time_e = time_e;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Complaint [complaint_id=" + complaint_id + ", describe=" + describe + ", type_t=" + type_t
				+ ", housename=" + housename + ", username=" + username + ", handle=" + handle + ", time_s=" + time_s
				+ ", time_e=" + time_e + ", telephone=" + telephone + "]";
	}
	public Complaint(Long complaint_id, String describe, Long type_t, String housename, String username, Handle handle,
			String time_s, String time_e, Long telephone) {
		this.complaint_id = complaint_id;
		this.describe = describe;
		this.type_t = type_t;
		this.housename = housename;
		this.username = username;
		this.handle = handle;
		this.time_s = time_s;
		this.time_e = time_e;
		this.telephone = telephone;
	}
	public Complaint() {
	}
	
}

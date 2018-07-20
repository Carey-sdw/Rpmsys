package com.rpm.domain;

public class Repair {
	private Long repair_id; 
	private String describe; 
	private Long type_t; 
	private String housename; 
	private String username; 
	private Handle handle; 
	private String time_t;
	private String time_e;
	private Long telephone;

	public Repair(Long repair_id, String describe, Long type_t, String housename, String username, Handle handle,
			String time_t, String time_e, Long telephone) {
		this.repair_id = repair_id;
		this.describe = describe;
		this.type_t = type_t;
		this.housename = housename;
		this.username = username;
		this.handle = handle;
		this.time_t = time_t;
		this.time_e = time_e;
		this.telephone = telephone;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public Long getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(Long repair_id) {
		this.repair_id = repair_id;
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
	public String getTime_t() {
		return time_t;
	}
	public void setTime_t(String time_t) {
		this.time_t = time_t;
	}
	public String getTime_e() {
		return time_e;
	}
	public void setTime_e(String time_e) {
		this.time_e = time_e;
	}
	@Override
	public String toString() {
		return "Repair [repair_id=" + repair_id + ", describe=" + describe + ", type_t=" + type_t + ", housename="
				+ housename + ", username=" + username + ", handle=" + handle + ", time_t=" + time_t + ", time_e="
				+ time_e + ", telephone=" + telephone + "]";
	}
	
	public Repair() {
	}

}

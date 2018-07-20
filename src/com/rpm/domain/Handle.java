package com.rpm.domain;

public class Handle {
	private Long handel_id;
	private String handelname;
	private Long telephone;
	private String describe;
	public Long getHandel_id() {
		return handel_id;
	}
	public void setHandel_id(Long handel_id) {
		this.handel_id = handel_id;
	}
	public String getHandelname() {
		return handelname;
	}
	public void setHandelname(String handelname) {
		this.handelname = handelname;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "Handle [handel_id=" + handel_id + ", handelname=" + handelname + ", telephone=" + telephone
				+ ", describe=" + describe + "]";
	}
	public Handle(Long handel_id, String handelname, Long telephone, String describe) {
		this.handel_id = handel_id;
		this.handelname = handelname;
		this.telephone = telephone;
		this.describe = describe;
	}
	public Handle() {
	}
	
	
	
}

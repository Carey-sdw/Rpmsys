package com.rpm.domain;
/**
 * 用户
 * @author Administrator
 *
 */
public class Users {
	private int user_id;
	private String username;
	private String userpwd;
	private String idcard;
	private String phone;
	private String time_s;
	
	public Users() {
	}
	public Users(int user_id, String username, String userpwd, String idcard, String phone, String time_s) {
		this.user_id = user_id;
		this.username = username;
		this.userpwd = userpwd;
		this.idcard = idcard;
		this.phone = phone;
		this.time_s = time_s;
	}

	public String getTime_s() {
		return time_s;
	}

	public void setTime_s(String time_s) {
		this.time_s = time_s;
	}

	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", userpwd=" + userpwd + ", idcard=" + idcard
				+ ", phone=" + phone + ", time_s=" + time_s + "]";
	}
	 
}

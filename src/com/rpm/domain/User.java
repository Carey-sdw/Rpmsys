package com.rpm.domain;
/**
 * 用户
 * @author Administrator
 *
 */
public class User {
	private int user_id;
	private String username;
	private String userpwd;
	private String idcard;//身份证
	private Long telephone;//电话号码
	private String occupancy_type;//入住类型
	private int occupancy_number;//入住人数
	private String registration_time;//登记时间
	private String describe;//描述
	private String house_name;//房屋
	private int from_id;//报表id
	private int repair_id;//报修id
	private int complaint_id; //投诉id
	private String photo_url;//图片路径
	private String time_e;
	
	public User(int user_id, String username, String userpwd, String idcard, Long telephone, String occupancy_type,
			int occupancy_number, String registration_time, String describe, String house_name, int from_id,
			int repair_id, int complaint_id, String photo_url, String time_e) {
		this.user_id = user_id;
		this.username = username;
		this.userpwd = userpwd;
		this.idcard = idcard;
		this.telephone = telephone;
		this.occupancy_type = occupancy_type;
		this.occupancy_number = occupancy_number;
		this.registration_time = registration_time;
		this.describe = describe;
		this.house_name = house_name;
		this.from_id = from_id;
		this.repair_id = repair_id;
		this.complaint_id = complaint_id;
		this.photo_url = photo_url;
		this.time_e = time_e;
	}
	public String getTime_e() {
		return time_e;
	}
	public void setTime_e(String time_e) {
		this.time_e = time_e;
	}
	public User() {
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getOccupancy_type() {
		return occupancy_type;
	}
	public void setOccupancy_type(String occupancy_type) {
		this.occupancy_type = occupancy_type;
	}
	public int getOccupancy_number() {
		return occupancy_number;
	}
	public void setOccupancy_number(int occupancy_number) {
		this.occupancy_number = occupancy_number;
	}
	public String getRegistration_time() {
		return registration_time;
	}
	public void setRegistration_time(String registration_time) {
		this.registration_time = registration_time;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(int repair_id) {
		this.repair_id = repair_id;
	}
	public int getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", userpwd=" + userpwd + ", idcard=" + idcard
				+ ", telephone=" + telephone + ", occupancy_type=" + occupancy_type + ", occupancy_number="
				+ occupancy_number + ", registration_time=" + registration_time + ", describe=" + describe
				+ ", house_name=" + house_name + ", from_id=" + from_id + ", repair_id=" + repair_id + ", complaint_id="
				+ complaint_id + ", photo_url=" + photo_url + ", time_e=" + time_e + "]";
	}         
}

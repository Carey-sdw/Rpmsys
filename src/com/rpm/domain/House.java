package com.rpm.domain;

public class House {
	private Long house_id;
	private String housename;// 房屋名
	private int room;// 室
	private int hall;// 厅
	private int kitchen;// 厨
	private int toilet;// 卫
	private Double acreage;// 面积
	private Double price;// 购价
	private Double rent;// 租金
	private int t_type;// 是否已售
	private User user;// 用户
	private int t_types;// 是否2手
	private int balcony;// 阳台
	private Long from_id;//表
	
	public House(Long house_id, String housename, int room, int hall, int kitchen, int toilet, Double acreage, Double price,
			Double rent, int t_type, User user, int t_types, int balcony, Long from_id) {
		this.house_id = house_id;
		this.housename = housename;
		this.room = room;
		this.hall = hall;
		this.kitchen = kitchen;
		this.toilet = toilet;
		if(acreage==null) {
			this.acreage = acreage;
		}else {
			this.acreage = (double)Math.round(acreage*100)/100;
		}
		if(price==null) {
			this.price = price;
		}else {
			this.price = (double)Math.round(price*100)/100;
		}
		if(rent==null) {
			this.rent = rent;
		}else {
			this.rent = (double)Math.round(rent*100)/100;
		}
		this.t_type = t_type;
		this.user = user;
		this.t_types = t_types;
		this.balcony = balcony;
		this.from_id = from_id;
	}

	public Long getFrom_id() {
		return from_id;
	}

	public void setFrom_id(Long from_id) {
		this.from_id = from_id;
	}

	public House() {
	}
	
	public Long getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Long id) {
		this.house_id = id;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public int getToilet() {
		return toilet;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
	}

	public Double getAcreage() {
		return acreage;
	}

	public void setAcreage(Double acreage) {
		if(acreage==null) {
			this.acreage = acreage;
		}else {
			this.acreage =  (double)Math.round(acreage*100)/100;
		}
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		if(price==null) {
			this.price = price;
		}else {
			this.price = (double)Math.round(price*100)/100;
		}
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		if(rent==null) {
			this.rent = rent;
		}else {
			this.rent = (double)Math.round(rent*100)/100;
		}
	}

	public int getT_type() {
		return t_type;
	}

	public void setT_type(int t_type) {
		this.t_type = t_type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user_id) {
		this.user= user_id;
	}

	public int getT_types() {
		return t_types;
	}

	public void setT_types(int t_types) {
		this.t_types = t_types;
	}

	public int getBalcony() {
		return balcony;
	}

	public void setBalcony(int balcony) {
		this.balcony = balcony;
	}

	@Override
	public String toString() {
		return "House [house_id=" + house_id + ", housename=" + housename + ", room=" + room + ", hall=" + hall
				+ ", kitchen=" + kitchen + ", toilet=" + toilet + ", acreage=" + acreage + ", price=" + price
				+ ", rent=" + rent + ", t_type=" + t_type + ", user=" + user + ", t_types=" + t_types + ", balcony="
				+ balcony + ", from_id=" + from_id + "]";
	}
}

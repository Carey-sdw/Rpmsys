package com.rpm.entity;


public class Houses {
	private String housename;// 房屋名
	private String room;// 室
	private String hall;// 厅
	private String kitchen;// 厨
	private String toilet;// 卫
	private String acreage;// 面积
	private String price;// 购价
	private String rent;//租金
	public Houses(String housename, String room, String hall, String kitchen, String toilet, String acreage,
			String price, String rent, String balcony) {
		this.housename = housename;
		this.room = room;
		this.hall = hall;
		this.kitchen = kitchen;
		this.toilet = toilet;
		this.acreage = acreage;
		this.price = price;
		this.rent = rent;
		this.balcony = balcony;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	private String balcony;// 阳台
	@Override
	public String toString() {
		return "Houses [housename=" + housename + ", room=" + room + ", hall=" + hall + ", kitchen=" + kitchen
				+ ", toilet=" + toilet + ", acreage=" + acreage + ", price=" + price + ", rent=" + rent + ", balcony="
				+ balcony + "]";
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getKitchen() {
		return kitchen;
	}
	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}
	public String getToilet() {
		return toilet;
	}
	public void setToilet(String toilet) {
		this.toilet = toilet;
	}
	public String getAcreage() {
		return acreage;
	}
	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBalcony() {
		return balcony;
	}
	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}
	
	public Houses() {
	}
	
}

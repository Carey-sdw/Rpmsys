package com.rpm.entity;

import com.rpm.domain.User;

public class FileUpImg {
	public String fileUpImg(User user) {
		String ss=user.getPhoto_url();
		String end=ss.substring(ss.length()-4);
		String imgurl=System.currentTimeMillis()+end;
		return imgurl;
	}
}

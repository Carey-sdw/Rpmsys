package com.rpm.mapper;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Users;

public interface LoginMapper {
	
	Users findusername(@Param("username")String username);
	
	void updateuserpwd(Users user); 
	
	void updateusertime(Users user); 
}

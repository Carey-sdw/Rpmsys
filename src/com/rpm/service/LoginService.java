package com.rpm.service;

import com.rpm.domain.Users;

public interface LoginService {
	
	Users findusername(String username); 
	
	void updateuserpwd(Users user);
	
	void updateusertime(Users user);
}

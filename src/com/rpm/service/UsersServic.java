package com.rpm.service;

import com.rpm.domain.Users;
/**
 * ???
 */
public interface UsersServic {
	Users findUser(String username,String userpwd);
}

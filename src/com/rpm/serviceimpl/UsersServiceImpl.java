package com.rpm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Users;
import com.rpm.mapper.UsersMapper;
import com.rpm.service.UsersServic;

@Service
@Transactional
public class UsersServiceImpl implements UsersServic {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users findUser(String username, String userpwd) {
		
		return usersMapper.findUser(username, userpwd);
	}

}

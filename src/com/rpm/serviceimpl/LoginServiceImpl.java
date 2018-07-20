package com.rpm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Users;
import com.rpm.mapper.LoginMapper;
import com.rpm.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public Users findusername(String username) {
		// TODO Auto-generated method stub
		return loginMapper.findusername(username);
	}

	@Override
	public void updateuserpwd(Users user) {
		loginMapper.updateuserpwd(user);
	}

	@Override
	public void updateusertime(Users user) {
		loginMapper.updateusertime(user);
	}

}

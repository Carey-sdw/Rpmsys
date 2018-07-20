package com.rpm.serviceimpl.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.User;
import com.rpm.mapper.update.UpdateUserMapper;
import com.rpm.service.update.UpdateUserService;

@Service
@Transactional
public class UpdateUserServiceImpl implements UpdateUserService {

	@Autowired
	private UpdateUserMapper updateUserMapper;
	
	@Override
	public void updateUser(User user) {
		updateUserMapper.updateUser(user);

	}

	@Override
	public void updateUserPhoto(String url, Long id) {
		// TODO Auto-generated method stub
		updateUserMapper.updateUserPhoto(url, id);
	}

}

package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.User;
import com.rpm.mapper.UsersMapper;
import com.rpm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public List<User> findusers(String username) {
		String name=username.toUpperCase();
		return usersMapper.findusers(name);
	}

	@Override
	public List<User> findAll() {
		return usersMapper.findAll();
	}

	@Override
	public List<User> pageUser(int offset, int limit) {
		return usersMapper.pageUser(offset, limit);
	}

	@Override
	public List<User> pageUsers(int offset, int limit, String username) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return usersMapper.pageUsers(offset, limit, name);
	}

	@Override
	public User findU(Long user_id) {
		// TODO Auto-generated method stub
		return usersMapper.findU(user_id);
	}

}

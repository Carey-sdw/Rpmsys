package com.rpm.service;

import java.util.List;

import com.rpm.domain.User;
/**
 * 用户
 */
public interface UserService {
	/*
	 * 根据姓名查
	 */
	List<User> findusers(String username);
	
	/*
	 * 查询所有
	 */
	List<User> findAll();
	
	/*
	 * 分页查从limit开始查到offset条
	 */
	List<User> pageUser(int offset,int limit);
	
	/*
	 * 分页查从limit开始查到offset条
	 */
	List<User> pageUsers(int offset,int limit,String username);
	
	User findU(Long user_id);
}

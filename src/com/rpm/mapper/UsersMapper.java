package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.User;
import com.rpm.domain.Users;

public interface UsersMapper {
	/*
	 * 登录用户查询
	 * @param username
	 * @param userpwd
	 * @return list
	 */
	//@Param注解的作用是给参数命名,参数命名后就能根据名字得到参数值,正确的将参数传入sql语句中 
	Users findUser(@Param("username")String username,@Param("userpwd")String userpwd);
	
	/*
	 * 根据用户名模糊查询
	 */
	List<User> findusers(@Param("name")String username);
	
	/*
	 * 查找所有用户
	 */
	List<User> findAll();
	
	/*
	 * 分页查询
	 */
	List<User> pageUser(@Param("offset") int offset, @Param("limit") int limit);
	
	/*
	 * 分页模糊查询
	 */
	List<User> pageUsers(@Param("offset") int offset, @Param("limit") int limit,@Param("usersname") String username);
	
	User findID(@Param("nameid")String nameid);
	
	User findU(@Param("user_id") Long user_id);
}

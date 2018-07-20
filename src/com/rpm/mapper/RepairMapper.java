package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Repair;
/**
 * 鈻捫敌谎?
 */
public interface RepairMapper {
	
	List<Repair> findAll();
	
	List<Repair> findAllNull();
	
	List<Repair> findPageAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Repair> findUser(@Param("username") String username);
	
	List<Repair> findPageUser(@Param("username") String username,@Param("offset") int offset, @Param("limit") int limit);
}

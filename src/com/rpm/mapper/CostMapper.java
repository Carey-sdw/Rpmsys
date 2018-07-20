package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Cost;
/**
 * 费用
 */
public interface CostMapper {
	
	List<Cost> findAll();
	
	List<Cost> findPageAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Cost> findUser(@Param("username") String username);
	
	List<Cost> findPageUser(@Param("username") String username,@Param("offset") int offset, @Param("limit") int limit);
	
	Cost findCost(@Param("housename")String housename);
}

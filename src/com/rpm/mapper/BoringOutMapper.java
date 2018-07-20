package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.BoringOut;
/**
 * 出库 
 */
public interface BoringOutMapper {
	List<BoringOut> findAll();
	
	List<BoringOut> findPageAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<BoringOut> findUser(@Param("username") String username);
	
	List<BoringOut> findPageUser(@Param("username") String username,@Param("offset") int offset, @Param("limit") int limit);

}

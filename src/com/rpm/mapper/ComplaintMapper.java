package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Complaint;
/**
 * 投诉
 * 
 */
public interface ComplaintMapper {
	
	List<Complaint> findAll();

	List<Complaint> findAllNull();
	
	List<Complaint> findPageAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Complaint> findUser(@Param("username") String username);
	
	List<Complaint> findPageUser(@Param("username") String username,@Param("offset") int offset, @Param("limit") int limit);
}

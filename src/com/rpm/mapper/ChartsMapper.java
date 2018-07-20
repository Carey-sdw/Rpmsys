package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Charts;

public interface ChartsMapper {
	
	List<Charts> findAll(@Param("tablename")String tablename);
	
	List<Charts> findPageAll(@Param("tablename") String username,@Param("offset") int offset, @Param("limit") int limit);

	Charts findHouse(@Param("tablename")String tablename,@Param("house_id")Long house_id);
}

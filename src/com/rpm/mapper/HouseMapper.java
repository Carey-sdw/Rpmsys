package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.House;

public interface HouseMapper {
	/*
	 * 查找所有
	 */
	List<House> findAll();
	
	/*
	 * 查找所有
	 */
	List<House> findAllNull();
	
	/*
	 * 分页查找所有
	 */
	List<House> findPagingAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/*
	 * 按名字查找
	 */
	List<House> findHousesName(@Param("fhsName") String houseName);
	
	
	/*
	 * 按名字分页查找
	 */
	List<House> findHouseName(@Param("fhName") String houseName,@Param("offset") int offset, @Param("limit") int limit);
	
	/*
	 * 按用户名查找
	 */
	List<House> findUserName(@Param("fuName") String userName);
	
	/*
	 * 房名
	 */
	House findHouseId(@Param("nameid")String nameid);
	
	/*
	 * id
	 */
	House findHouse(@Param("id")Long id);
}

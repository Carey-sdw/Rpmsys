package com.rpm.service;

import java.util.List;

import com.rpm.domain.House;
/**
 * 房屋查询
 * @author Administrator
 *
 */
public interface HouseService {
	/**
	 * 查找所有
	 */
	List<House> findAll();
	
	/**
	 * 查找所有
	 */
	List<House> findAllNull();
	
	/**
	 * 分页查找所有
	 */
	List<House> findPagingAll(int offset,int limit);
	
	/**
	 * 按名字查找
	 */
	List<House> findHousesName(String houseName);
	
	/**
	 * 按名字分页查找
	 */
	List<House> findHouseName(String houseName,int offset,int limit);
	
	/**
	 * 按用户名查找
	 */
	List<House> findUserName(String userName);
	/**
	 * 根据房屋名查
	 */
	House findHouseId(String nameid);
	/**
	 * 根据房屋id查
	 */
	House findHouse(Long id);
}

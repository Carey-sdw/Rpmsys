package com.rpm.service;

import java.util.List;

import com.rpm.domain.Cost;
/**
 * 价格
 */
public interface CostService {

	List<Cost> findAll();
	
	List<Cost> findPageAll(int offset,int limit);
	
	List<Cost> findUser(String username);
	
	List<Cost> findPageUser(String username,int offset,int limit);
	
	Cost find(String housename);
}

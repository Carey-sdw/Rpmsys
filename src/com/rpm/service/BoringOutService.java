package com.rpm.service;

import java.util.List;

import com.rpm.domain.BoringOut;
/**
 * 出库
 */
public interface BoringOutService {

	List<BoringOut> findAll();
	
	List<BoringOut> findPageAll(int offset,int limit);
	
	List<BoringOut> findUser(String username);
	
	List<BoringOut> findPageUser(String username,int offset,int limit);
}

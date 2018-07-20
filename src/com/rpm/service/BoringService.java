package com.rpm.service;

import java.util.List;


import com.rpm.domain.Boring;
/**
 * 入库
 */
public interface BoringService {

	List<Boring> findAll();
	
	List<Boring> findPageAll(int offset,int limit);
	
	List<Boring> findUser(String username);
	
	Boring findsUser(String username,String type_t);
	
	List<Boring> findPageUser(String username,int offset,int limit);
}

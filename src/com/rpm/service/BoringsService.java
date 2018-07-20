package com.rpm.service;

import java.util.List;

import com.rpm.domain.Boring;
import com.rpm.domain.BoringOut;
import com.rpm.domain.Borings;
/**
 * 入库查询
 */
public interface BoringsService {

	List<Borings> findAll();
	
	List<Borings> findUsers(String username);
	
	Boring findUser(String username,String type_t);
	
	BoringOut findOut(String username,String type_t);
	
	Borings findsUser(String username,String type_t);
}

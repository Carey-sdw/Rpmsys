package com.rpm.service;

import java.util.List;

import com.rpm.domain.Repair;
/**
 * ▒еля
 */
public interface RepairService {

	List<Repair> findAll();
	
	List<Repair> findAllNull();
	
	List<Repair> findPageAll(int offset,int limit);
	
	List<Repair> findUser(String username);
	
	List<Repair> findPageUser(String username,int offset,int limit);
}

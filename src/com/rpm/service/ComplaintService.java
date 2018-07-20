package com.rpm.service;

import java.util.List;

import com.rpm.domain.Complaint;
/**
 * 投诉
 */
public interface ComplaintService {

	List<Complaint> findAll();

	List<Complaint> findAllNull();
	
	List<Complaint> findPageAll(int offset,int limit);
	
	List<Complaint> findUser(String username);
	
	List<Complaint> findPageUser(String username,int offset,int limit);
}

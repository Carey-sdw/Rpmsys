package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Complaint;
import com.rpm.mapper.ComplaintMapper;
import com.rpm.service.ComplaintService;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService{

	@Autowired
	private ComplaintMapper complaintMapper;
	
	@Override
	public List<Complaint> findAll() {
		return complaintMapper.findAll();
	}

	@Override
	public List<Complaint> findUser(String username) {
		// TODO Auto-generated method stub

		String name=username.toUpperCase();
		return complaintMapper.findUser(name);
	}

	@Override
	public List<Complaint> findPageAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return complaintMapper.findPageAll(offset, limit);
	}

	@Override
	public List<Complaint> findPageUser(String username, int offset, int limit) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return complaintMapper.findPageUser(name, offset, limit);
	}

	@Override
	public List<Complaint> findAllNull() {
		// TODO Auto-generated method stub
		return complaintMapper.findAllNull();
	}

}

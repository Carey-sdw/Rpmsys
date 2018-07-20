package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Repair;
import com.rpm.mapper.RepairMapper;
import com.rpm.service.RepairService;

@Service
@Transactional
public class RepairServiceImpl implements RepairService{

	@Autowired
	private RepairMapper repairMapper;
	
	@Override
	public List<Repair> findAll() {
		return repairMapper.findAll();
	}

	@Override
	public List<Repair> findUser(String username) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return repairMapper.findUser(name);
	}

	@Override
	public List<Repair> findPageAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return repairMapper.findPageAll(offset, limit);
	}

	@Override
	public List<Repair> findPageUser(String username, int offset, int limit) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return repairMapper.findPageUser(name, offset, limit);
	}

	@Override
	public List<Repair> findAllNull() {
		// TODO Auto-generated method stub
		return repairMapper.findAllNull();
	}

}

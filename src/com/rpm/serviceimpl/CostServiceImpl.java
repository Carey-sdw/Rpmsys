package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Cost;
import com.rpm.mapper.CostMapper;
import com.rpm.service.CostService;

@Service
@Transactional
public class CostServiceImpl implements CostService{

	@Autowired
	private CostMapper costMapper;
	
	@Override
	public List<Cost> findAll() {
		return costMapper.findAll();
	}

	@Override
	public List<Cost> findUser(String username) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return costMapper.findUser(name);
	}

	@Override
	public List<Cost> findPageAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return costMapper.findPageAll(offset, limit);
	}

	@Override
	public List<Cost> findPageUser(String username, int offset, int limit) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return costMapper.findPageUser(name, offset, limit);
	}

	@Override
	public Cost find(String housename) {
		// TODO Auto-generated method stub
		return costMapper.findCost(housename);
	}

}

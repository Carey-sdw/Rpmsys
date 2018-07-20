package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.House;
import com.rpm.mapper.HouseMapper;
import com.rpm.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseMapper houseMapper;
	
	@Override
	public List<House> findAll() {
		// TODO Auto-generated method stub
		return houseMapper.findAll();
	}

	@Override
	public List<House> findHouseName(String houseName,int offset,int limit) {

		String name=houseName.toUpperCase();
		return houseMapper.findHouseName(name,offset,limit);
	}

	@Override
	public List<House> findUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<House> findPagingAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return houseMapper.findPagingAll(offset, limit);
	}

	@Override
	public List<House> findHousesName(String houseName) {
		String name=houseName.toUpperCase();
		return houseMapper.findHousesName(name);
	}

	@Override
	public List<House> findAllNull() {
		// TODO Auto-generated method stub
		return houseMapper.findAllNull();
	}

	@Override
	public House findHouseId(String nameid) {
		// TODO Auto-generated method stub
		String name=nameid.toUpperCase();
		return houseMapper.findHouseId(name);
	}

	@Override
	public House findHouse(Long id) {
		// TODO Auto-generated method stub
		return houseMapper.findHouse(id);
	}
}

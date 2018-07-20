package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Boring;
import com.rpm.domain.BoringOut;
import com.rpm.domain.Borings;
import com.rpm.mapper.BoringsMapper;
import com.rpm.service.BoringsService;

@Service
@Transactional
public class BoringsServiceImpl  implements BoringsService{

	@Autowired
	private BoringsMapper boringsMapper;

	@Override
	public List<Borings> findAll() {
		// TODO Auto-generated method stub
		return boringsMapper.findAll();
	}

	@Override
	public List<Borings> findUsers(String username) {
		// TODO Auto-generated method stub
		return boringsMapper.findUsers(username);
	}

	@Override
	public Boring findUser(String username, String type_t) {
		// TODO Auto-generated method stub
		return boringsMapper.findUser(username, type_t);
	}

	@Override
	public Borings findsUser(String username, String type_t) {
		// TODO Auto-generated method stub
		return boringsMapper.findsUser(username, type_t);
	}

	@Override
	public BoringOut findOut(String username, String type_t) {
		// TODO Auto-generated method stub
		return boringsMapper.findOut(username, type_t);
	}
	
}

package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.BoringOut;
import com.rpm.mapper.BoringOutMapper;
import com.rpm.service.BoringOutService;

@Service
@Transactional
public class BoringOutServiceImpl implements BoringOutService {

	@Autowired
	private BoringOutMapper boringOutMapper;
	
	@Override
	public List<BoringOut> findAll() {
		// TODO Auto-generated method stub
		return boringOutMapper.findAll();
	}

	@Override
	public List<BoringOut> findPageAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return boringOutMapper.findPageAll(offset, limit);
	}

	@Override
	public List<BoringOut> findUser(String username) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return boringOutMapper.findUser(name);
	}

	@Override
	public List<BoringOut> findPageUser(String username, int offset, int limit) {
		// TODO Auto-generated method stub

		String name=username.toUpperCase();
		return boringOutMapper.findPageUser(name, offset, limit);
	}

}

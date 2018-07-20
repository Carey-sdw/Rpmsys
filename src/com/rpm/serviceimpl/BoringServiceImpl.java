package com.rpm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Boring;
import com.rpm.mapper.BoringMapper;
import com.rpm.service.BoringService;

@Service
@Transactional
public class BoringServiceImpl  implements BoringService{

	@Autowired
	private BoringMapper boringMapper;
	
	@Override
	public List<Boring> findAll() {
		return boringMapper.findAll();
	}

	@Override
	public List<Boring> findUser(String username) {
		// TODO Auto-generated method stub

		String name=username.toUpperCase();
		return boringMapper.findUser(name);
	}

	@Override
	public List<Boring> findPageAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return boringMapper.findPageAll(offset, limit);
	}

	@Override
	public List<Boring> findPageUser(String username, int offset, int limit) {
		// TODO Auto-generated method stub
		String name=username.toUpperCase();
		return boringMapper.findPageUser(name, offset, limit);
	}

	@Override
	public Boring findsUser(String username, String type_t) {
		// TODO Auto-generated method stub
		return boringMapper.findsUser(username, type_t);
	}

}

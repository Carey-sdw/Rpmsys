package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Complaint;
import com.rpm.mapper.add.AddCompMapper;
import com.rpm.service.add.AddCompService;

@Service
@Transactional
public class AddCompServiceImpl implements AddCompService {

	@Autowired
	private AddCompMapper addCompMapper;
	
	@Override
	public void addComp(Complaint complaint) {
		// TODO Auto-generated method stub
		addCompMapper.addComp(complaint);
	}

	@Override
	public void updateComp(Complaint complaint) {
		// TODO Auto-generated method stub
		addCompMapper.updateComp(complaint);
	}

}

package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.BoringOut;
import com.rpm.entity.Formatting;
import com.rpm.mapper.BoringsMapper;
import com.rpm.mapper.add.AddOutBoringMapper;
import com.rpm.service.add.AddOutBoringService;

@Service
@Transactional
public class AddOutBoringServiceImpl implements AddOutBoringService {

	@Autowired
	private AddOutBoringMapper addOutBoringMapper;
	
	@Autowired
	private BoringsMapper boringsMapper;
	
	@Override
	public void addOutBoring(BoringOut boringOut) {
		Formatting date=new Formatting();
		boringOut.setTime_s(date.ymdhms());
		Long enumber=boringOut.getBnumber()-boringOut.getNumber_s();
		boringOut.setEnumber(enumber);
		boringOut.setBorings_id(boringsMapper.findsUser(boringOut.getBoringname(), boringOut.getType_t()).getBorings_id());
		addOutBoringMapper.addOutBoring(boringOut);
		boringsMapper.updateBorings(enumber, boringOut.getBorings_id());	
	}

}

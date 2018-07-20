package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Boring;
import com.rpm.domain.Borings;
import com.rpm.entity.Formatting;
import com.rpm.mapper.BoringsMapper;
import com.rpm.mapper.add.AddBoringMapper;
import com.rpm.service.add.AddBoringService;

@Service
@Transactional
public class AddBoringServiceImpl implements AddBoringService {

	@Autowired
	private AddBoringMapper addBoringMapper;
	
	@Autowired
	private BoringsMapper boringsMapper;
	@Override
	public void addBoring(Boring boring) {
		Formatting date=new Formatting();
		boring.setTime_s(date.ymdhms());
		Long bnumber=boring.getNumber_s()+boringsMapper.findsUser(boring.getBoringname(), boring.getType_t()).getNumber_e();
		boring.setBnumber(bnumber);
		boring.setBorings_id(boringsMapper.findsUser(boring.getBoringname(), boring.getType_t()).getBorings_id());
		addBoringMapper.addBoring(boring);//入库记录
		boringsMapper.updateBorings(bnumber, boring.getBorings_id());//更改库存
		
	}

	@Override
	public void addBorings(Borings borings) {
		addBoringMapper.addBorings(borings);
	}

	@Override
	public void addsBoring(Boring boring) {
		Formatting date=new Formatting();
		boring.setTime_s(date.ymdhms());
		Long bnumber=boring.getNumber_s();
		boring.setBnumber(bnumber);
		boring.setBorings_id(boringsMapper.findsUser(boring.getBoringname(), boring.getType_t()).getBorings_id());
		addBoringMapper.addBoring(boring);
	}

}

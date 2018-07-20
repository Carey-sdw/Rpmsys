package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Repair;
import com.rpm.mapper.add.AddRepairMapper;
import com.rpm.service.add.AddRepairService;

@Service
@Transactional
public class AddRepairServiceImpl implements AddRepairService {

	@Autowired
	private AddRepairMapper addRepairMapper;
	
	@Override
	public void addRepair(Repair repair) {
		// TODO Auto-generated method stub
		addRepairMapper.addRepair(repair);
	}

	@Override
	public void updateRepair(Repair repair) {
		// TODO Auto-generated method stub
		addRepairMapper.updateRepair(repair);
	}

}

package com.rpm.serviceimpl.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.mapper.update.DeleteCRMapper;
import com.rpm.service.update.DeleteCRService;

@Service
@Transactional
public class DeleteCRServiceImpl implements DeleteCRService {
	
	@Autowired
	private DeleteCRMapper deleteCRMapper;
	
	/**
	 * 删除投诉
	 */
	@Override
	public void deleteComp(Long complaint_id) {
		// TODO Auto-generated method stub
		deleteCRMapper.deleteComp(complaint_id);
	}

	/**
	 * 删除评论
	 */
	@Override
	public void deleteRepair(Long repair_id) {
		// TODO Auto-generated method stub
		deleteCRMapper.deleteRepair(repair_id);
	}

}

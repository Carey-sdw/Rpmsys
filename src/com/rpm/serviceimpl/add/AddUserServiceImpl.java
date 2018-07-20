package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.User;
import com.rpm.mapper.UsersMapper;
import com.rpm.mapper.add.AddUserMapper;
import com.rpm.mapper.update.UpdateChartMapper;
import com.rpm.mapper.update.UpdateHouseMapper;
import com.rpm.service.add.AddUserService;

@Service
@Transactional
public class AddUserServiceImpl implements AddUserService {

	@Autowired
	private AddUserMapper addUserMapper;
	
	@Autowired
	private UsersMapper userMapper;
	
	@Autowired
	private UpdateChartMapper updateChartMapper;
	
	@Autowired 
	private UpdateHouseMapper updateHouseMapper;
	
	@Override
	public void addUsers(User user) {
		//增加用户

		addUserMapper.addUsers(user);
		
		User findID = userMapper.findID(user.getUsername());
//		System.out.println(findID);
//		System.out.println(findID.getUser_id()+"--"+findID.getFrom_id());
		//相关表更改
		updateChartMapper.updg(findID.getUser_id(), findID.getFrom_id());
		updateChartMapper.upde(findID.getUser_id(), findID.getFrom_id());
		updateChartMapper.updp(findID.getUser_id(), findID.getFrom_id());
		updateChartMapper.updo(findID.getUser_id(), findID.getFrom_id());
		updateChartMapper.updw(findID.getUser_id(), findID.getFrom_id());
		updateChartMapper.updfrom(findID.getUser_id(), user.getHouse_name());
		
		updateHouseMapper.updateHouse(user.getHouse_name(),findID.getUser_id());

	}

}

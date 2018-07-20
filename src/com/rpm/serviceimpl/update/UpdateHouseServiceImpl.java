package com.rpm.serviceimpl.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.House;
import com.rpm.mapper.update.DeleteFromMapper;
import com.rpm.mapper.update.DeleteUserMapper;
import com.rpm.mapper.update.UpdateHouseMapper;
import com.rpm.service.HouseService;
import com.rpm.service.update.UpdateHouseService;

@Service
@Transactional
public class UpdateHouseServiceImpl implements UpdateHouseService {

	@Autowired
	private UpdateHouseMapper updateHouseMapper;
	
	@Autowired
	private DeleteUserMapper deleteUserMapper;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private DeleteFromMapper deleteFromMapper;
	
	@Override
	public void updateHouses(House house) {
		// TODO Auto-generated method stub
		updateHouseMapper.updateHouses(house);
	}

	@Override
	public void deleteHouse(Long house_id) {
		// TODO Auto-generated method stub
		House findHouse = houseService.findHouse(house_id);
		/*
		 * 删除住户
		 */
		if(findHouse.getUser()!=null) {
//			System.out.println(findHouse.getUser().getUser_id());
			deleteUserMapper.deleteUser(findHouse.getUser().getUser_id());
		}
		/*
		 * 删除水电气等表
		 */
		deleteFromMapper.dele(house_id);
		deleteFromMapper.delw(house_id);
		deleteFromMapper.delo(house_id);
		deleteFromMapper.delp(house_id);
		deleteFromMapper.delg(house_id);
		deleteFromMapper.delfrom(findHouse.getFrom_id());
		/*
		 * 删除房屋		
		 */
		updateHouseMapper.deleteHouse(house_id);
		
	}

}

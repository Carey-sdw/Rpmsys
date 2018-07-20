package com.rpm.serviceimpl.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.User;
import com.rpm.mapper.UsersMapper;
import com.rpm.mapper.update.DeleteUserMapper;
import com.rpm.mapper.update.UpdateChartMapper;
import com.rpm.mapper.update.UpdateHouseMapper;
import com.rpm.service.update.DeleteUserService;

@Service
@Transactional
public class DeleteUserServiceImpl implements DeleteUserService {

	@Autowired
	private DeleteUserMapper deleteUserMapper;
	
	@Autowired
	private UpdateChartMapper updateChartMapper;
	
	@Autowired
	private UpdateHouseMapper updateHouseMapper;
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void deleteUser(int user_id) {
		// TODO Auto-generated method stub
		User findU = usersMapper.findU((long)user_id);
		
		updateChartMapper.updg(0, findU.getFrom_id());
		updateChartMapper.upde(0, findU.getFrom_id());
		updateChartMapper.updp(0, findU.getFrom_id());
		updateChartMapper.updo(0, findU.getFrom_id());
		updateChartMapper.updw(0, findU.getFrom_id());
		updateChartMapper.updfrom(0, findU.getHouse_name());
		
		updateHouseMapper.updHouse(findU.getHouse_name(),0);

		deleteUserMapper.deleteUser(user_id);
	}

}

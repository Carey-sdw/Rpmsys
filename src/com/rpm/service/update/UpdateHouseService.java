package com.rpm.service.update;

import com.rpm.domain.House;
/**
 * 房屋修改和删除
 * @author Administrator
 *
 */
public interface UpdateHouseService {
	void updateHouses(House house);
	
	void deleteHouse(Long house_id);
}

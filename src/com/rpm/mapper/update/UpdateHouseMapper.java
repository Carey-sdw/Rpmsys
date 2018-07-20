package com.rpm.mapper.update;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.House;
/**
 * 房屋修改与删除
 * @author Administrator
 *
 */
public interface UpdateHouseMapper {
	void updateHouse(@Param("housename")String housename,@Param("user_id")int user_id);
	
	void updHouse(@Param("housename")String housename,@Param("user_id")int user_id);
	
	void updateHousef(@Param("housename")String housename,@Param("from_id")int from_id);
	
	void updateHouses(House house);
	
	void deleteHouse(@Param("house_id")Long house_id);
}

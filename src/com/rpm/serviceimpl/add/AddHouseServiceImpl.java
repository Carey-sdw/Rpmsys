package com.rpm.serviceimpl.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Charts;
import com.rpm.domain.House;
import com.rpm.entity.Formatting;
import com.rpm.entity.Houses;
import com.rpm.mapper.FromsMapper;
import com.rpm.mapper.HouseMapper;
import com.rpm.mapper.add.AddFromMapper;
import com.rpm.mapper.add.AddHouseMapper;
import com.rpm.mapper.update.UpdateChartMapper;
import com.rpm.service.add.AddHouseService;

@Service
@Transactional
public class AddHouseServiceImpl implements AddHouseService{

	@Autowired
	private AddHouseMapper addHouseMapper;
		
	@Autowired 
	private AddFromMapper addFromMapper;
	
	@Autowired
	private FromsMapper fromsMapper;
	
	@Autowired
	private HouseMapper houseMapper;
	
	@Autowired
	private UpdateChartMapper updateChartMapper;
	
	@Override
	public void addHouse(Houses houses) {
		House house=new House();
		house.setHousename(houses.getHousename());
		if(houses.getRoom().trim()!="") {
			house.setRoom(Integer.parseInt(houses.getRoom().trim()));
		}
		if(houses.getHall().trim()!="") {
			house.setHall(Integer.parseInt(houses.getHall().trim()));
		}
		if(houses.getKitchen().trim()!="") {
			house.setKitchen(Integer.parseInt(houses.getKitchen().trim()));
		}
		if(houses.getToilet().trim()!="") {
			house.setToilet(Integer.parseInt(houses.getToilet().trim()));
		}
		if(houses.getAcreage().trim()!="") {
			house.setAcreage((double) Integer.parseInt(houses.getAcreage().trim()));
		}
		if(houses.getPrice().trim()!="") {
			house.setPrice((double) Integer.parseInt(houses.getPrice().trim()));
		}
		if(houses.getRent().trim()!="") {
			
			house.setRent((double) Integer.parseInt(houses.getRent().trim()));
			house.setT_types(1);
		}else {
			
			house.setRent(0d);
			house.setT_types(0);
		}
		house.setT_type(0);
		if(houses.getBalcony()=="1") {
			house.setBalcony(1);
		}
		
//		System.out.println(house);
		//增加表
		addFromMapper.addFrom(houses.getHousename().trim());
		Charts charts=new Charts();
		Long from_id=fromsMapper.findId(houses.getHousename().trim()).getFrom_id();
		
		house.setFrom_id(from_id);
		//增加房屋
		addHouseMapper.addHouse(house);
		
		Long house_id=houseMapper.findHouseId(houses.getHousename()).getHouse_id();
		
		Formatting f=new Formatting();
		charts.setHouse_id(house_id);
		charts.setTtime(f.ymd());
		charts.setTtype(from_id);
		charts.setTvalue(0d);
		charts.setTvalues(0d);
		charts.setType_t(0l);
		updateChartMapper.adde(charts);
		updateChartMapper.addg(charts);
		updateChartMapper.addo(charts);
		updateChartMapper.addp(charts);
		updateChartMapper.addw(charts);
		
	}

}

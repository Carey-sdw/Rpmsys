package com.rpm.controller.admin.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.entity.Houses;
import com.rpm.service.HouseService;
import com.rpm.service.add.AddHouseService;

@Controller
public class AddHouseController {
	
	@Autowired
	private AddHouseService addHouseService;
	
	@Autowired
	private HouseService houseService;
	
	/*
	 * 转到添加页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/addfw")
	public String addFw() {
		return "admin/addfw";
	}
	/*
	 * 新增用户
	 */
	@RequestMapping(method=RequestMethod.POST,value="/addhouse")
	public String addHouse(Houses house,Model model){
//		
//		System.out.println(house);
		house.setHousename(house.getHousename().toUpperCase());
		addHouseService.addHouse(house);
		return "redirect:houselist";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addhouses",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addHouses(String house){
		String h=house.trim().toUpperCase();
		if(houseService.findHouseId(h)!=null) {
			return "1";
		}
//		System.out.println(house);
		return "0";
	}
}

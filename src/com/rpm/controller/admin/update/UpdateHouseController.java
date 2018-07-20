package com.rpm.controller.admin.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.House;
import com.rpm.service.HouseService;
import com.rpm.service.update.UpdateHouseService;

@Controller
public class UpdateHouseController {
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private UpdateHouseService updateHouseService;
	
	/*
	 * 转到修改页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/updatehouse")
	public String updateUser(Long id,Model model) {
		model.addAttribute("house", houseService.findHouse(id));
		return "admin/housedetails";
	}
	/*
	 * 转到修改页面
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updatehouse",produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House updateUsers(House house) {
		try {
			updateHouseService.updateHouses(house);
			house.setHousename("用户资料修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			house.setHousename("未按要求修改，用户资料修改失败!");
		}
		return house;
	}
}

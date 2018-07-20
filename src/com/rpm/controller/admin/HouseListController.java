package com.rpm.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class HouseListController {

	@Autowired
	private HouseService houseService;
	
	@Autowired
	private UpdateHouseService updateHouseService;
	
	/*
	 * 初次加载
	 */
	@RequestMapping(method=RequestMethod.GET,value="/houselist")
	public String houseListAll(Model model) {
		//每页大小
		int pagesize=6;
		int page=1;
		model.addAttribute("page", page);
		List<House> houses= houseService.findAll();
		int pagenumber = 1;
		//总页数
		if(houses.size()%pagesize==0) {
			pagenumber=houses.size()/pagesize;
		}else {
			pagenumber=houses.size()/pagesize+1;
		}
		model.addAttribute("pagenumber", pagenumber);
		int offset=page*pagesize;
		int limit=(page-1)*pagesize;
		model.addAttribute("house", houseService.findPagingAll(offset, limit));
		
		return "admin/houselist";
	}

	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/houselist",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<House> houseTable(String page,String housesname) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(housesname==null||housesname.equals("")) {
			List<House> house = houseService.findPagingAll(offset, limit);
			return house;
		}
		List<House> house = houseService.findHouseName(housesname,offset, limit);
		return house;
	}
	
	/*
	 * 收索房屋
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cablehouselist")
	public String cableHouseList(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String houseName=requst.getParameter("cablehouselist").trim();
		List<House> findAll = houseService.findHousesName(houseName);
		int pagenumber = 1;
		//总页数
		if(findAll.size()%pagesize==0) {
			pagenumber=findAll.size()/pagesize;
		}else {
			pagenumber=findAll.size()/pagesize+1;
		}
		model.addAttribute("pagenumber", pagenumber);
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		List<House> house = houseService.findHouseName(houseName,offset, limit);
		model.addAttribute("house",house);
		model.addAttribute("housesname",houseName);
		return "admin/houselist";
	}
	/*
	 * 删除用户
	 */
	@RequestMapping(method=RequestMethod.POST,value="/delhouse",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<House> delUser(Long house_id,String page,String housesname) {
		
		updateHouseService.deleteHouse(house_id);

		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(housesname==null||housesname.equals("")) {
			
			return houseService.findPagingAll(offset, limit);
		}
		return houseService.findHouseName(housesname, offset, limit);
	}
	
}

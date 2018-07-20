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

@Controller
public class HouseTableController {
	
	@Autowired
	private HouseService houserService;
	
	/*
	 * 初始化
	 */
	@RequestMapping(method=RequestMethod.GET,value="/housetable")
	public String houseTable(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<House> findAll = houserService.findAll();
		int pagenumber = 0;
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
		List<House> house = houserService.findPagingAll(offset, limit);
		model.addAttribute("house",house);
//		System.out.println(houserService.findAll());
//		System.out.println(houserService.findHouseName("A",1,0));
//		System.out.println(houserService.findHousesName("A"));
//		System.out.println(house);
//		System.out.println(houserService.findPagingAll(7, 0));
		return "admin/housetable";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/housetable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<House> houseTable(String page,String housesname) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(housesname==null||housesname.equals("")) {
			List<House> house = houserService.findPagingAll(offset, limit);
			return house;
		}
		List<House> house = houserService.findHouseName(housesname,offset, limit);
		return house;
	}
	
	
	/*
	 * 收索房屋
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cablehouses")
	public String cableHouses(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String houseName=requst.getParameter("cablehouses").trim();
		List<House> findAll = houserService.findHousesName(houseName);
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
		List<House> house = houserService.findHouseName(houseName,offset, limit);
		model.addAttribute("house",house);
		model.addAttribute("housesname",houseName);
		return "admin/housetable";
	}
}

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

import com.rpm.domain.Repair;
import com.rpm.service.RepairService;

@Controller
public class RepairController {
	@Autowired
	private RepairService repairService;
	
	@RequestMapping(method=RequestMethod.GET,value="/repairtable")
	public String repair(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<Repair> findAll = repairService.findAll();
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
		List<Repair> repair = repairService.findPageAll(offset, limit);
		model.addAttribute("repair",repair);
		return "admin/repairtable";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/repairtable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Repair> repairTable(String page,String username) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(username==null||username.equals("")) {
			List<Repair> repair = repairService.findPageAll(offset, limit);
			return repair;
		}
		List<Repair> repair = repairService.findPageUser(username, offset, limit);

		return repair;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/cablerepairs")
	public String repairs(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String username=requst.getParameter("cablerepairs").trim();
		List<Repair> findAll = repairService.findUser(username);
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
		List<Repair> repair = repairService.findPageUser(username, offset, limit);
		model.addAttribute("repair",repair);
		model.addAttribute("repairsname",username);
		
		return "admin/repairtable";
	}
}

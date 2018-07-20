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

import com.rpm.domain.Cost;
import com.rpm.service.CostService;

@Controller
public class CostController {
	@Autowired
	private CostService costService;
	
	@RequestMapping(method=RequestMethod.GET,value="/costtable")
	public String repair(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<Cost> findAll = costService.findAll();
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
		List<Cost> cost = costService.findPageAll(offset, limit);
		model.addAttribute("cost",cost);
		return "admin/costtable";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/costtable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Cost> repairTable(String page,String username) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(username==null||username.equals("")) {
			List<Cost> cost = costService.findPageAll(offset, limit);
			return cost;
		}
		List<Cost> cost = costService.findPageUser(username, offset, limit);

		return cost;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/costcable")
	public String repairs(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String username=requst.getParameter("costcables").trim();
		List<Cost> findAll = costService.findUser(username);
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
		List<Cost> cost = costService.findPageUser(username, offset, limit);
		model.addAttribute("cost",cost);
		model.addAttribute("costsname",username);
		return "admin/costtable";
	}
}

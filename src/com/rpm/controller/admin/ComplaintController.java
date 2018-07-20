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

import com.rpm.domain.Complaint;
import com.rpm.service.ComplaintService;

@Controller
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;
	
	@RequestMapping(method=RequestMethod.GET,value="/complainttable")
	public String complaint(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<Complaint> findAll = complaintService.findAll();
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
		List<Complaint> complaint = complaintService.findPageAll(offset, limit);
		model.addAttribute("complaint",complaint);
		return "admin/complainttable";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/complainttable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Complaint> complaintTable(String page,String username) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(username==null||username.equals("")) {
			List<Complaint> complaint = complaintService.findPageAll(offset, limit);
			return complaint;
		}
		List<Complaint> complaint = complaintService.findPageUser(username, offset, limit);

		return complaint;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/cablecomplaints")
	public String complaints(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String username=requst.getParameter("cablecomplaints").trim();
		List<Complaint> findAll = complaintService.findUser(username);
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
		List<Complaint> complaint = complaintService.findPageUser(username, offset, limit);
		model.addAttribute("complaint",complaint);
		model.addAttribute("complaintsname",username);
		
		return "admin/complainttable";
	}
}

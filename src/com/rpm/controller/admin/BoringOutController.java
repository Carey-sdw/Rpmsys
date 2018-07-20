package com.rpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rpm.domain.BoringOut;
import com.rpm.service.BoringOutService;

@Controller
public class BoringOutController {
	@Autowired
	private BoringOutService boringService;
	
	@RequestMapping(method=RequestMethod.GET,value="/boringouttable")
	public String Boring(String page,Model model) {
		//每页大小
		int pagesize=8;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<BoringOut> findAll = boringService.findAll();
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
		List<BoringOut> boring = boringService.findPageAll(offset, limit);
		model.addAttribute("boring",boring);
		model.addAttribute("Tabletype", "出库");
		return "admin/boringtable";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/boringouttable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BoringOut> BoringTable(String page,String username) {
		//每页大小
		int pagesize=8;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(username==null||username.equals("")) {
			List<BoringOut> boring = boringService.findPageAll(offset, limit);
			return boring;
		}
		List<BoringOut> boring = boringService.findPageUser(username, offset, limit);

		return boring;
	}
	
}

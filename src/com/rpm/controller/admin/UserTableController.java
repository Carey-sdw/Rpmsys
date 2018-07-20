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

import com.rpm.domain.User;
import com.rpm.service.UserService;

@Controller
public class UserTableController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/usertable")
	public String userTable(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<User> user=userService.findAll();
		int pagenumber = 0;
		//总页数
		if(user.size()%pagesize==0) {
			pagenumber=user.size()/pagesize;
		}else {
			pagenumber=user.size()/pagesize+1;
		}
		model.addAttribute("pagenumber", pagenumber);
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		List<User> users=userService.pageUser(offset,limit);
		model.addAttribute("user",users);
		return "admin/usertable";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/usertable",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> userTables(String page,String username) {
		if(username==null||username.equals("")) {
			//每页大小
			int pagesize=6;
			if(page==null) {
				page="1";
			}
			//每页的用户
			int offset=Integer.parseInt(page)*pagesize;
			int limit=(Integer.parseInt(page)-1)*pagesize;
			//System.out.println(userService.pageUser(offset,limit));
			return userService.pageUser(offset,limit);
		}
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		//System.out.println(userService.pageUser(offset,limit));
		return userService.pageUsers(offset,limit,username);
	}
	
	/*
	 * 收索用户
	 */

	@RequestMapping(method=RequestMethod.POST,value="/cableuser")
	public String cableUser(String page,HttpServletRequest reuest,Model model) {
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String username=reuest.getParameter("cableuser").trim();
		List<User> user=userService.findusers(username);
		
		int pagenumber = 1;
		//总页数
		if(user.size()%pagesize==0) {
			pagenumber=user.size()/pagesize;
		}else {
			pagenumber=user.size()/pagesize+1;
		}
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("user", userService.pageUsers(offset, limit,username));
		model.addAttribute("usersname", username);
		return "admin/usertable";
	}

}

package com.rpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.User;
import com.rpm.entity.Formatting;
import com.rpm.service.UserService;
import com.rpm.service.add.AddUserService; 

@Controller
public class ImgListController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddUserService addUserService;
	/*
	 * 第一次
	 */
	@RequestMapping(method=RequestMethod.GET,value="/imglist")
	public String imgList1(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<User> user=userService.findAll();
		int pagenumber = 1;
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
		return "admin/imglist";
	}
	
	/*
	 * 上下首尾
	 */
	@RequestMapping(method=RequestMethod.POST,value="/imglist",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> imgList(String page,Model model,String username) {
		if(username==null||username.equals("")) {
			//每页大小
			int pagesize=6;
	//		System.out.println(page);
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
			int pagesize=8;
	//				System.out.println(page);
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
	 * 转到添加页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/addyh")
	public String addYh(String house_name,Model model,String from_id) {
		Formatting date=new Formatting();
		model.addAttribute("house_name", house_name);
		model.addAttribute("registration_time", date.ymd());
		model.addAttribute("from_id", from_id);
		return "admin/addyh";
	}
	/*
	 * 新增用户
	 */
	@RequestMapping(method=RequestMethod.POST,value="/adduser")
	public String addUser(User user){
		addUserService.addUsers(user);
		return "redirect:imglist";
	}
}

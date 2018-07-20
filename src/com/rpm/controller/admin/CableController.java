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
import com.rpm.service.update.DeleteUserService;

@Controller
public class CableController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeleteUserService deleteUserService;
	/*
	 * 收索用户
	 */

	@RequestMapping(method=RequestMethod.POST,value="/cable")
	public String cableUser(String page,HttpServletRequest reuest,Model model) {
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<User> user=userService.findusers(reuest.getParameter("cableuser").trim());
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
		model.addAttribute("user", userService.pageUsers(offset, limit, reuest.getParameter("cableuser").trim()));
		model.addAttribute("usersname", reuest.getParameter("cableuser"));
		return "admin/imglist";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cable")
	public String cableUser() {
		return "admin/imglist";
	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(method=RequestMethod.POST,value="/deluser",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> delUser(int user_id,String page,String username) {
		deleteUserService.deleteUser(user_id);
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(username==null||username.equals("")) {
			return userService.pageUser(offset,limit);
		}
		
		//System.out.println(userService.pageUser(offset,limit));
		return userService.pageUsers(offset,limit,username);
	}
}

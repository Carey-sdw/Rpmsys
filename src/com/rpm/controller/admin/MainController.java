package com.rpm.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpm.domain.Complaint;
import com.rpm.domain.Repair;
import com.rpm.service.ComplaintService;
import com.rpm.service.RepairService;

@Controller
public class MainController {
	@Autowired
	private RepairService repair;
	@Autowired
	private ComplaintService comp;
	
	@RequestMapping(method=RequestMethod.GET,value="/main")
	public String main(HttpSession session,Model model) {
		if(session.getAttribute("userlogin")==null) {
			return "redirect:/login";
		}
		List<Repair> list4 = repair.findAllNull();
		List<Complaint> list5=comp.findAllNull();
		model.addAttribute("copmnumber", list4.size()+list5.size());
		return "admin/main";
		
	}
		
	/*
	@RequestMapping(method=RequestMethod.POST,value="/main")
	public String mains(LoginUser request, RedirectAttributes redirectAttributes) {
		 String userName = request.getusername();
		  String password = request.getuserpwd();
		  //重定向到 /main 的Controller方法(即main1)上
		  //重定向传递参数的两种方法
		  redirectAttributes.addAttribute("username", userName);
		  redirectAttributes.addFlashAttribute("userpwd", password);
		return "redirect:/main1";//重定向
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/main1")
	public String main(HttpServletRequest request) {
		System.out.println(request.getParameter("username"));
		String userName = request.getParameter("username");
		  request.setAttribute("username", userName);
		return "admin/main";
		
	}
	@RequestMapping(method=RequestMethod.GET,value="/main")
	public String main1(HttpServletRequest request) {
		return "admin/main";
		
	}
	 */
	
}

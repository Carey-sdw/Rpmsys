package com.rpm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpm.domain.House;
import com.rpm.domain.Repair;
import com.rpm.domain.User;
import com.rpm.entity.Formatting;
import com.rpm.service.HouseService;
import com.rpm.service.RepairService;
import com.rpm.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService user;
	@Autowired
	private HouseService houses;
	@Autowired
	private RepairService repair;
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String mains(Model model) {
		Formatting fd=new Formatting();
		model.addAttribute("nowtime", fd.hh());
		List<User> list = user.findAll();
		List<House> list2 = houses.findAll();
		List<House> list3 = houses.findAllNull();
		List<Repair> list4 = repair.findAllNull();
		model.addAttribute("usernumber", list.size());
		model.addAttribute("housesnumber", list2.size());
		model.addAttribute("housenumber", list3.size());
		model.addAttribute("repairnumber", list4.size());
		return "admin/index";
	}
}

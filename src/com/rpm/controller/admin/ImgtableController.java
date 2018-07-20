package com.rpm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImgtableController {
	
	@RequestMapping(method=RequestMethod.GET,value="/imgtable")
	public String imgTable() {
		return "admin/imgtable";
	}
}

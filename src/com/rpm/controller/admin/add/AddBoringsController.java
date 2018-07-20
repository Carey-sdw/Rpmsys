package com.rpm.controller.admin.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpm.domain.Boring;
import com.rpm.domain.Borings;
import com.rpm.service.BoringsService;
import com.rpm.service.add.AddBoringService;

@Controller
public class AddBoringsController {
	
	@Autowired
	private BoringsService boringsService;
	
	@Autowired
	private AddBoringService addBoringService;

	@RequestMapping(method=RequestMethod.POST,value="/boringslist")
	public String addBoring(Boring boring,Model model) {
//		System.out.println(boring);
		Borings borings=new Borings();
		borings.setBoringname(boring.getBoringname());
		borings.setNumber_e(boring.getNumber_s());
		borings.setType_t(boring.getType_t());
//		System.out.println(borings);
		addBoringService.addBorings(borings);
		addBoringService.addsBoring(boring);
		List<Borings> bs= boringsService.findAll();
		model.addAttribute("borings",bs);
		return "redirect:boringlist";	
	}
	
}

package com.rpm.controller.admin.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.Boring;
import com.rpm.domain.BoringOut;
import com.rpm.domain.Borings;
import com.rpm.service.BoringsService;
import com.rpm.service.add.AddOutBoringService;

@Controller
public class AddBoringOutController {
	
	@Autowired
	private BoringsService boringsService;
	
	@Autowired
	private AddOutBoringService addOutBoringService;

	@RequestMapping(method=RequestMethod.GET,value="/boringoutlist")
	public String addOutBoring(String page,Model model) {
		
		List<Borings> borings= boringsService.findAll();
		model.addAttribute("borings",borings);
		return "admin/boringoutlist";	
	}
	/*
	 * 物品
	 */
	@RequestMapping(method=RequestMethod.POST,value="/boringoutlist",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Borings> Borings(String username) {
		List<Borings> borings= boringsService.findUsers(username);
		return borings;	
	}
	/*
	 * 类型
	 */
	@RequestMapping(method=RequestMethod.POST,value="/boringsoutlist",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boring Borings(String username,String type_t) {
//		System.out.println(username+type_t);
		Borings bor=boringsService.findsUser(username, type_t);
		Boring borings= boringsService.findUser(username, type_t);
		borings.setBnumber(bor.getNumber_e());
		return borings;	
	}
	/*
	 * 入库
	 */
	@RequestMapping(method=RequestMethod.POST,value="/addoutboring",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BoringOut Borings(BoringOut boring) {
		addOutBoringService.addOutBoring(boring);
		BoringOut b=new BoringOut();
		b.setBnumber(boring.getBnumber()-boring.getNumber_s());
		b.setBoringname("出库成功 ！");
		return b;	
	}
}

package com.rpm.controller.admin.update;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.Price;
import com.rpm.entity.Chart;
import com.rpm.service.add.AddChartService;
import com.rpm.service.add.AddPriceService;

@Controller
public class UpdatePayController {
	@Autowired
	private AddPriceService addPriceService;
	
	@Autowired
	private AddChartService addChartService;
	
	@RequestMapping(method=RequestMethod.GET,value="paylist")
	public String pay(Model model) {
		List<Price> price=addPriceService.findAll();
		model.addAttribute("price", price);
		return "admin/paylist";
	}
	/*
	 * 查找
	 */
	@RequestMapping(method=RequestMethod.POST,value="paylist",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Chart pay(String pricename,String housename) {
//		System.out.println(addChartService.findHouse(pricename, housename));
		return addChartService.findHouse(pricename, housename);
	}
	
	/*
	 * 缴费
	 */
	@RequestMapping(method=RequestMethod.POST,value="updpay",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updpay(String pricename,String housename) {
//		System.out.println(addChartService.findHouse(pricename, housename));
		addChartService.update(pricename, housename);
		return "1";
	}
}

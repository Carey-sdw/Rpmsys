package com.rpm.controller.admin.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.Price;
import com.rpm.service.add.AddPriceService;

@Controller
public class AddPriceController {
	
	@Autowired
	private AddPriceService addPriceService;
	
	@RequestMapping(method=RequestMethod.GET,value="pricelist")
	public String price(Model model) {
		List<Price> price=addPriceService.findAll();
		model.addAttribute("price", price);
		return "admin/pricelist";
	}
	/*
	 * 下拉框
	 */
	@RequestMapping(method=RequestMethod.POST,value="pricelist",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Price priceName(Price prices) {
		Price price=addPriceService.findPrice(prices.getPricename());
		return price;
	}
	/*
	 * 修改
	 */
	@RequestMapping(method=RequestMethod.POST,value="updprice",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Price updPrice(Price price) {
		addPriceService.updatePrice(price);
		Price s=new Price();
		s.setPricename("修改成功!");;
		return s;
	}
	
}

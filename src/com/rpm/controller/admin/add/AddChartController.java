package com.rpm.controller.admin.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.entity.Chart;
import com.rpm.service.add.AddChartService;

@Controller
public class AddChartController {
	
	@Autowired
	private AddChartService addChartService;
	/*
	 * 查找表
	 */
	@RequestMapping(method=RequestMethod.POST,value="chartlist",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Chart> charts(String pricename) {
//		System.out.println(pricename);
		List<Chart> chart=addChartService.findChartAll(pricename);
//		System.out.println(chart);
		return chart;
	}
	
	/*
	 * 录入
	 */
	@RequestMapping(method=RequestMethod.POST,value="updateprice",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Chart> updateprice(Chart chart) {
//		System.out.println("-----"+chart);
		String name=chart.getPricename();
		addChartService.updateChart(chart);//录入
//		System.out.println(chart.getPricename());
//		System.out.println(name);
		List<Chart> charts=addChartService.findChartAll(name);
//		System.out.println(charts);
		return charts;
	}
}

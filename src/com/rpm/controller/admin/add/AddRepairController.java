package com.rpm.controller.admin.add;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.House;
import com.rpm.domain.Repair;
import com.rpm.entity.Formatting;
import com.rpm.service.HouseService;
import com.rpm.service.RepairService;
import com.rpm.service.add.AddRepairService;
import com.rpm.service.update.DeleteCRService;

@Controller
public class AddRepairController {
	
	@Autowired
	private DeleteCRService deleteCRService;
	
	@Autowired
	private HouseService houseService;

	@Autowired
	private AddRepairService addRepairService;
	
	@Autowired
	private RepairService repairService;
	
	/*
	 * 转到添加页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/addrepair")
	public String addRepair() {
		return "admin/addrepair";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addrepair",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Repair addRepair(Repair repair) {
		Formatting time=new Formatting();
		repair.setTime_t(time.ymdhms());
		repair.setType_t(0L);
		addRepairService.addRepair(repair);
		Repair rep=new Repair();
		rep.setHousename("添加成功!!!");
		return rep;
	}
	
	/*
	 * add收索房屋
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cablerepairhouse",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House cableHouseList(String housesname) {
		House house = houseService.findHouseId(housesname);
		return house;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/repairlist")
	public String repair(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<Repair> findAll = repairService.findAll();
		int pagenumber = 0;
		//总页数
		if(findAll.size()%pagesize==0) {
			pagenumber=findAll.size()/pagesize;
		}else {
			pagenumber=findAll.size()/pagesize+1;
		}
		model.addAttribute("pagenumber", pagenumber);
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		List<Repair> repair = repairService.findPageAll(offset, limit);
		model.addAttribute("repair",repair);
		return "admin/repairlist";
	}
	
	/*
	 * 上下首位
	 */
	@RequestMapping(method=RequestMethod.POST,value="/repairlist",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Repair> repairTable(String page,String repairsname) {
		//每页大小
		int pagesize=6;
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(repairsname==null||repairsname.equals("")) {
			List<Repair> repair = repairService.findPageAll(offset, limit);
			return repair;
		}
		List<Repair> repair = repairService.findPageUser(repairsname, offset, limit);

		return repair;
	}
	
	
	/*
	 * 收索
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cablerepairlist")
	public String repairs(String page,Model model,HttpServletRequest requst) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		String username=requst.getParameter("cablehouselist").trim();
		List<Repair> findAll = repairService.findUser(username);
		int pagenumber = 1;
		//总页数
		if(findAll.size()%pagesize==0) {
			pagenumber=findAll.size()/pagesize;
		}else {
			pagenumber=findAll.size()/pagesize+1;
		}
		model.addAttribute("pagenumber", pagenumber);
		//每页的用户
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		List<Repair> repair = repairService.findPageUser(username, offset, limit);
		model.addAttribute("repair",repair);
		model.addAttribute("repairsname",username);
		return "admin/repairlist";
	}
	
	/*
	 * 删除报修
	 */
	@RequestMapping(method=RequestMethod.POST,value="/delrepair",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Repair> delRepair(Long repair_id,String page,String repairsname) {
		deleteCRService.deleteRepair(repair_id);
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的报修
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(repairsname==null||repairsname.equals("")) {
			return repairService.findPageAll(offset, limit);
		}
		
		//System.out.println(userService.pageUser(offset,limit));
		return repairService.findPageUser(repairsname, offset, limit);
	}
	
	/*
	 * 处理报修
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updrepair",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Repair> updRepair(Long repair_id,String page,String repairsname,Long type_t) {
		Repair repair=new Repair();
		Formatting date=new Formatting();
		repair.setRepair_id(repair_id);
		repair.setType_t(type_t+1L);
		repair.setTime_e(date.ymdhms());
		addRepairService.updateRepair(repair);
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的报修
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(repairsname==null||repairsname.equals("")) {
			return repairService.findPageAll(offset, limit);
		}
		
		//System.out.println(userService.pageUser(offset,limit));
		return repairService.findPageUser(repairsname, offset, limit);
	}
}

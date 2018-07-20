package com.rpm.controller.admin.add;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpm.domain.Complaint;
import com.rpm.domain.House;
import com.rpm.entity.Formatting;
import com.rpm.service.ComplaintService;
import com.rpm.service.HouseService;
import com.rpm.service.add.AddCompService;
import com.rpm.service.update.DeleteCRService;

@Controller
public class AddCompController {
	
	@Autowired
	private HouseService houseService;

	@Autowired
	private AddCompService addCompService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private DeleteCRService deleteCRService;
	
	/*
	 * 转到添加页面
	 */
	@RequestMapping(method=RequestMethod.GET,value="/addcomp")
	public String addComp() {
		return "admin/addcomp";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addcomp",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Complaint addComplaint(Complaint complaint) {
		Formatting time=new Formatting();
		complaint.setTime_s(time.ymdhms());
		complaint.setType_t(0L);
		addCompService.addComp(complaint);
		Complaint comp=new Complaint();
		comp.setHousename("添加成功!!!");
		return comp;
	}
	
	/*
	 * 收索房屋
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cablecomphouse",
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House cableHouseList(String housesname) {
		House house = houseService.findHouseId(housesname);
		return house;
	}
	
	/*
	 * 第一次
	 */
	@RequestMapping(method=RequestMethod.GET,value="/complaintlist")
	public String complaint(String page,Model model) {
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		model.addAttribute("page", page);
		List<Complaint> findAll = complaintService.findAll();
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
		List<Complaint> complaint = complaintService.findPageAll(offset, limit);
		model.addAttribute("complaint",complaint);
		return "admin/complaintlist";
	}
	
	
	/*
	 * 删除投诉
	 */
	@RequestMapping(method=RequestMethod.POST,value="/delcomplaint",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Complaint> delComplaint(Long complaint_id,String page,String complaintsname) {
		deleteCRService.deleteComp(complaint_id);
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的报修
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(complaintsname==null||complaintsname.equals("")) {
			return complaintService.findPageAll(offset, limit);
		}
		
		//System.out.println(userService.pageUser(offset,limit));
		return complaintService.findPageUser(complaintsname, offset, limit);
	}
	
	/*
	 * 处理投诉
	 */
	@RequestMapping(method=RequestMethod.POST,value="/updcomplaint",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Complaint> updComplaint(Long complaint_id,String page,String complaintsname,Long type_t) {
		Complaint complaint=new Complaint();
		Formatting date=new Formatting();
		complaint.setComplaint_id(complaint_id);
		complaint.setType_t(type_t+1L);
		complaint.setTime_e(date.ymdhms());
		addCompService.updateComp(complaint);
		//每页大小
		int pagesize=6;
		if(page==null) {
			page="1";
		}
		//每页的报修
		int offset=Integer.parseInt(page)*pagesize;
		int limit=(Integer.parseInt(page)-1)*pagesize;
		if(complaintsname==null||complaintsname.equals("")) {
			return complaintService.findPageAll(offset, limit);
		}
		
		//System.out.println(userService.pageUser(offset,limit));
		return complaintService.findPageUser(complaintsname, offset, limit);
	}
}

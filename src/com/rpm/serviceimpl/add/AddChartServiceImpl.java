package com.rpm.serviceimpl.add;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Charts;
import com.rpm.domain.House;
import com.rpm.entity.Chart;
import com.rpm.entity.Formatting;
import com.rpm.mapper.ChartsMapper;
import com.rpm.mapper.update.UpdateChartMapper;
import com.rpm.service.HouseService;
import com.rpm.service.add.AddChartService;

@Service
@Transactional
public class AddChartServiceImpl implements AddChartService{
	
	@Autowired
	private ChartsMapper chartsMapper;
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private UpdateChartMapper updateChartMapper;

	@Override
	public void addChart(Chart chart) {
		
	}

	@Override
	public List<Chart> findChartAll(String pricename) {
		// TODO Auto-generated method stub
		List<Chart> listchart=new ArrayList<>();
		String tablename=null;
		List<Charts> list=null;
		if(pricename.equals("电费")||pricename.equals("电表")) {
			tablename="electric_bill";     
		}
		if(pricename.equals("水费")||pricename.equals("水表")) {
			tablename="water_bill";		
		}
		if(pricename.equals("燃气费")||pricename.equals("燃气表")) {
			tablename="gas_bill";
		}
		if(pricename.equals("物业费")||pricename.equals("物业表")) {
			tablename="property_bill";
		}
		if(pricename.equals("其他费用")||pricename.equals("其他")) {
			tablename="other";
		}
		if(tablename!=null) {
			list=chartsMapper.findAll(tablename);
//			System.out.println(list);
		}else {
			return listchart;
		}
		
		if(list!=null) {
			
			for (Charts charts : list) {
				Chart chart=new Chart();
				chart.setHouse_name(
						houseService.findHouse(
								charts.getHouse_id()
								).getHousename()
						);
				if(houseService.findHouse(
						charts.getHouse_id()
						).getUser()!=null) {
					chart.setUsername(
							houseService.findHouse(
									charts.getHouse_id()
									).getUser().getUsername()
							);
				}else {
					chart.setUsername("暂无住户");
				}
				
				chart.setTvalue(charts.getTvalues());//上次数
				chart.setTtime(charts.getTtime());
				chart.setTds(charts.getTds());
				chart.setType_t(charts.getType_t());
				chart.setTvalues(charts.getTvalue());//本次数
				chart.setTtype(charts.getTtype());
				listchart.add(chart);
			}
		}
		return listchart;
	}
	
	/*
	 *录入
	 */
	@Override
	public void updateChart(Chart chart) {
		// TODO Auto-generated method stub
		Formatting f=new Formatting();
		chart.setTtime(f.ymd());
		chart.setType_t(1L);
		if(chart.getPricename().equals("电表")) {
			chart.setPricename("electric_bill");     
		}
		if(chart.getPricename().equals("水表")) {
			chart.setPricename("water_bill");		
		}
		if(chart.getPricename().equals("燃气表")) {
			chart.setPricename("gas_bill");
		}
		if(chart.getPricename().equals("物业表")) {
			chart.setPricename("property_bill");
		}
		if(chart.getPricename().equals("其他")) {
			chart.setPricename("other");
		}
//		System.out.println(chart);
		updateChartMapper.updateChart(chart);//相关表录入
		updateChartMapper.updateForm(chart);//更改form表
	}

	/*
	 * 缴费查询
	 * */
	@Override
	public Chart findHouse(String pricename, String housename) {
		// TODO Auto-generated method stub
//		System.out.println(pricename);
		String tablename=null;
		if(pricename.equals("电费")||pricename.equals("电表")) {
			tablename="electric_bill";     
		}
		if(pricename.equals("水费")||pricename.equals("水表")) {
			tablename="water_bill";		
		}
		if(pricename.equals("燃气费")||pricename.equals("燃气表")) {
			tablename="gas_bill";
		}
		if(pricename.equals("物业费")||pricename.equals("物业表")) {
			tablename="property_bill";
		}
		if(pricename.equals("其他费用")||pricename.equals("其他")) {
			tablename="other";
		}
		Chart chart=null;//实体类
		House house=houseService.findHouseId(housename);
		Charts charts=chartsMapper.findHouse(tablename, house.getHouse_id());//封装类
//		System.out.println("house:"+house.getHouse_id());	
//		System.out.println(charts);
		if(charts!=null) {
			chart=new Chart();
			chart.setHouse_name(housename.toUpperCase());
			if(house.getUser()!=null) {
				chart.setUsername(house.getUser().getUsername());
			}else {
				chart.setUsername("暂无住户");
			}
			chart.setPrice(charts.getPrice());
//			System.out.println(chart);
		}
		return chart;
	}

	
	/*
	 * 缴费
	 **/
	@Override
	public void update(String pricename, String housename) {
		housename=housename.toUpperCase();
		String tablename=null;
		if(pricename.equals("电费")||pricename.equals("电表")) {
			tablename="electric_bill";     
		}
		if(pricename.equals("水费")||pricename.equals("水表")) {
			tablename="water_bill";		
		}
		if(pricename.equals("燃气费")||pricename.equals("燃气表")) {
			tablename="gas_bill";
		}
		if(pricename.equals("物业费")||pricename.equals("物业表")) {
			tablename="property_bill";
		}
		if(pricename.equals("其他费用")||pricename.equals("其他")) {
			tablename="other";
		}
				
		Long house_id = houseService.findHouseId(housename).getHouse_id();
//		System.out.println(house_id);
		updateChartMapper.update(tablename, house_id);
		updateChartMapper.updateform(tablename, housename);
		
	}

	

}

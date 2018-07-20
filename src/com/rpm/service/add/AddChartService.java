package com.rpm.service.add;

import java.util.List;

import com.rpm.entity.Chart;

public interface AddChartService {
	
	void addChart(Chart chart);
	
	List<Chart> findChartAll(String pricename);
	
	void updateChart(Chart chart);
	
	Chart findHouse(String tablename,String housename);
	
	void update(String tablename,String housename);
}

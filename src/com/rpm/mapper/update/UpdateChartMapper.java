package com.rpm.mapper.update;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Charts;
import com.rpm.entity.Chart;

public interface UpdateChartMapper {
	//抄表录入
	void updateChart(Chart chart);
	//抄表时更新费用
	void updateForm(Chart chart);
	//增加水表
	void addw(Charts charts);
	//增加电表
	void adde(Charts charts);
	//增加燃气表
	void addg(Charts charts);
	//增加其他表
	void addo(Charts charts);
	//增加物业表
	void addp(Charts charts);
	//动态更改表
	void update(@Param("pricename")String pricename,@Param("house_id") Long house_id);
	//更改收费表
	void updateform(@Param("pricename")String pricename,@Param("housename") String housename);
	//更改表用户
	void updw(@Param("user_id") int user_id,@Param("house_id") int from_id);

	void upde(@Param("user_id") int user_id,@Param("house_id") int from_id);

	void updg(@Param("user_id") int user_id,@Param("house_id") int from_id);
	
	void updo(@Param("user_id") int user_id,@Param("house_id") int from_id);
	
	void updp(@Param("user_id") int user_id,@Param("house_id") int from_id);
	
	void updfrom(@Param("user_id") int user_id,@Param("housename") String housename);
}

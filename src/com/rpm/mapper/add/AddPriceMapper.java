package com.rpm.mapper.add;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Price;

public interface AddPriceMapper {
	 
	List<Price> findAll();
	
	Price findPrice(@Param("pricename") String pricename);

	void addPrice(Price price);
	
	void updatePrice(Price price);
}

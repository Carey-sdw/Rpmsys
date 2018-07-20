package com.rpm.service.add;

import java.util.List;

import com.rpm.domain.Price;

public interface AddPriceService {
	
	void addPrice(Price price);
	
	Price findPrice(String pricename);
	
	void updatePrice(Price price);
	
	List<Price> findAll();
}

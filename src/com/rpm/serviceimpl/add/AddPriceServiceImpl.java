package com.rpm.serviceimpl.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpm.domain.Price;
import com.rpm.mapper.add.AddPriceMapper;
import com.rpm.service.add.AddPriceService;

@Service
@Transactional
public class AddPriceServiceImpl implements AddPriceService {

	@Autowired
	private AddPriceMapper addPriceMapper;
	
	@Override
	public void addPrice(Price price) {
		// TODO Auto-generated method stub
		addPriceMapper.addPrice(price);
	}

	@Override
	public void updatePrice(Price price) {
		// TODO Auto-generated method stub
		addPriceMapper.updatePrice(price);
	}

	@Override
	public List<Price> findAll() {
		// TODO Auto-generated method stub
		return addPriceMapper.findAll();
	}

	@Override
	public Price findPrice(String pricename) {
		// TODO Auto-generated method stub
		return addPriceMapper.findPrice(pricename);
	}

}

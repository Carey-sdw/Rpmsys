package com.rpm.mapper;

import java.util.List;

import com.rpm.domain.Property;

public interface PropertyMapper {
	/*
	 * 查询所有账单
	 */
	List<Property> findAll();
}

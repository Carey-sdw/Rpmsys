package com.rpm.mapper;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Froms;
/**
 * 费用
 */
public interface FromsMapper {
	
	Froms findId(@Param("houseid")String housename);

}

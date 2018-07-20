package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Boring;
import com.rpm.domain.BoringOut;
import com.rpm.domain.Borings;
/**
 * 入库
 * 
 */
public interface BoringsMapper {
	/**
	 * 查询所有
	 */
	List<Borings> findAll();
	/**
	 * 按名字查询一级下拉框
	 */
	List<Borings> findUsers(@Param("username") String username);
	/**
	 * 入库按名字型号查二级下拉框
	 * 
	 */
	Boring findUser(@Param("usersname") String username,@Param("type_t") String type_t);
	/**
	 * 出库按名字型号查二级下拉框
	 * 
	 */
	BoringOut findOut(@Param("usersname") String username,@Param("type_t") String type_t);
	/**
	 * 出库按名字型号查所有
	 * 
	 */
	Borings findsUser(@Param("usersname") String username,@Param("type_t") String type_t);
	/**
	 * 入库更改库存
	 */
	void updateBorings(@Param("number_e") Long number_e,@Param("borings_id") Long borings_id);
}

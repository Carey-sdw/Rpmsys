package com.rpm.mapper.update;

import org.apache.ibatis.annotations.Param;
/**
 * 抄表删除
 * @author Administrator
 *
 */
public interface DeleteFromMapper {
	/**
	 * 水表删除
	 * @param house_id
	 */
	void delw(@Param("house_id") Long house_id);
	/**
	 * 电表删除
	 * @param house_id
	 */
	void dele(@Param("house_id") Long house_id);
	/**
	 * 燃气 表删除
	 * @param house_id
	 */
	void delg(@Param("house_id") Long house_id);
	/**
	 * 其他表删除
	 * @param house_id
	 */
	void delo(@Param("house_id") Long house_id);
	/**
	 * 物业表删除
	 * @param house_id
	 */
	void delp(@Param("house_id") Long house_id);
	/**
	 * 账单表删除
	 * @param house_id
	 */
	void delfrom(@Param("from_id") Long from_id);

}

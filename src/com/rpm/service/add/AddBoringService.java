package com.rpm.service.add;

import com.rpm.domain.Boring;
import com.rpm.domain.Borings;
/**
 * 入库
 * @author Administrator
 *
 */
public interface AddBoringService {
	/**
	 *入库
	 */
	void addBoring(Boring boring);
	
	/**
	 * 增加类型
	 */
	void addBorings(Borings borings);
	/**
	 * 新增物料
	 * @param boring
	 */
	void addsBoring(Boring boring);
}

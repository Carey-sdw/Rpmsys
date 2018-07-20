package com.rpm.mapper.add;

import com.rpm.domain.Boring;
import com.rpm.domain.Borings;

public interface AddBoringMapper {
	/**
	 * 入库
	 */
	void addBoring(Boring boring);
	
	/**
	 * 第一次新增
	 */
	void addBorings(Borings borings);
}

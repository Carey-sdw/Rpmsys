package com.rpm.mapper.add;

import org.apache.ibatis.annotations.Param;

/*
 * 新建表
 */
public interface AddFromMapper {

		void addFrom(@Param("hname")String hname);
}

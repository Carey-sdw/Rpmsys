package com.rpm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.Boring;
/**
 * 入库
 * 
 */
public interface BoringMapper {
	List<Boring> findAll();
	
	List<Boring> findPageAll(@Param("offset") int offset, @Param("limit") int limit);
	
	List<Boring> findUser(@Param("username") String username);
	
	Boring findsUser(@Param("usersname") String username,@Param("type_t") String type_t);
	
	List<Boring> findPageUser(@Param("username") String username,@Param("offset") int offset, @Param("limit") int limit);

}

package com.rpm.mapper.update;

import org.apache.ibatis.annotations.Param;

import com.rpm.domain.User;

public interface UpdateUserMapper {
	void updateUser(User user);

	
	void updateUserPhoto(@Param("url")String url,@Param("id")Long id);
}

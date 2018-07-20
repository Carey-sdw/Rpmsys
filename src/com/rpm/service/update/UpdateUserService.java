package com.rpm.service.update;

import com.rpm.domain.User;

public interface UpdateUserService {
	void updateUser(User user);
	
	void updateUserPhoto(String url,Long id);
}

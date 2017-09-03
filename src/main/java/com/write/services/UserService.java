package com.write.services;

import com.write.models.User;

public interface UserService {
	User getUserById(Integer id);

	User saveUser(User user);

	void deleteUser(Integer id);
}

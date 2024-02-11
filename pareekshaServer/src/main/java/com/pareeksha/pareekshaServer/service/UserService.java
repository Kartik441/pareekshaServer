package com.pareeksha.pareekshaServer.service;

import java.util.Set;

import com.pareeksha.pareekshaServer.entity.User;
import com.pareeksha.pareekshaServer.entity.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles);
	public User getUserByName(String userName);
	public void deleteUserById(Long userId);

}

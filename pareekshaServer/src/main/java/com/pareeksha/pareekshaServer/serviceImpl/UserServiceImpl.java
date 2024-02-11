package com.pareeksha.pareekshaServer.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pareeksha.pareekshaServer.entity.User;
import com.pareeksha.pareekshaServer.entity.UserRole;
import com.pareeksha.pareekshaServer.helper.UserFoundException;
import com.pareeksha.pareekshaServer.repo.RoleRepository;
import com.pareeksha.pareekshaServer.repo.UserRepository;
import com.pareeksha.pareekshaServer.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles)  {
		
		User local = userRepository.findByUserName(user.getUserName());
		if(local != null) {
			System.out.println("User already present");
			//throw new Exception("User already exists!!!");
			//throw new UserFoundException("User already exists...");
			return null;
		}
		else {
			
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = userRepository.save(user);
			return local;
		}
	}

	@Override
	public User getUserByName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUserById(Long userId) {
		
		 userRepository.deleteById(userId);;
	}

}

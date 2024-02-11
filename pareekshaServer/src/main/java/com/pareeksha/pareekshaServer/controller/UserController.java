package com.pareeksha.pareekshaServer.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.pareeksha.pareekshaServer.entity.Role;
import com.pareeksha.pareekshaServer.entity.User;
import com.pareeksha.pareekshaServer.entity.UserRole;
import com.pareeksha.pareekshaServer.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	private User createUser(@RequestBody User user){
		user.setProfile("default.png");
		
		// encoding password with BcryptPasswordEncoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Role role =  new Role(45L, "Normal");
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole(user, role);
		userRoles.add(userRole);
		return userService.createUser(user, userRoles);
	}
	
	
	@GetMapping("/{userName}")
	private User getUserByName(@PathVariable("userName") String userName) {
		return userService.getUserByName(userName);
	}
	
	@DeleteMapping("/{userId}")
	private void deleteUserById(@PathVariable("userId") Long userId) {
		userService.deleteUserById(userId);
	}

}

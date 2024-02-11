package com.pareeksha.pareekshaServer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pareeksha.pareekshaServer.entity.Role;
import com.pareeksha.pareekshaServer.entity.User;
import com.pareeksha.pareekshaServer.entity.UserRole;
import com.pareeksha.pareekshaServer.service.UserService;

@SpringBootApplication
public class PareekshaServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(PareekshaServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Running server..");
////		//User user = new User(12L, "Smit", "root", "smit", "vav", "@gmail.com", true, "profile");
//		User user = new User();
//		user.setFirstName("smit" );
//		user.setLastName("vavliya" );
//		user.setUserName("smit1");
//		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));	
//		user.setEmail("smit@");
//		user.setProfile("default.png");
//		
//			
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		System.out.println("Running server..2");
////
////		
////		
//		Set<UserRole> userRoles = new HashSet<>();
//		UserRole userRole= new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoles.add(userRole);
////		userRoles.add(userRole);
//		System.out.println("Running server..3");
//		User user1 =this.userService.createUser(user, userRoles);
//		System.out.println(user1.getFirstName());	
////		
//		System.out.println("Running server..4");
	}

}

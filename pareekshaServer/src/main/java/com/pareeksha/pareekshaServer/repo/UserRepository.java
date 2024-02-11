package com.pareeksha.pareekshaServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pareeksha.pareekshaServer.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserName(String name);

}

package com.pareeksha.pareekshaServer.helper;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
		super("User with this name already exists...try another name");
	}
	
	public UserFoundException(String mssg) {
		super(mssg);
	}

}

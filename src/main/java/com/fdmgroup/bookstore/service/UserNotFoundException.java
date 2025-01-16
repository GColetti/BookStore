package com.fdmgroup.bookstore.service;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 6505802709032985857L;

	public UserNotFoundException(String message) {
		super(message);
	}

}

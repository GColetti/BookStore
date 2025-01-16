package com.fdmgroup.bookstore.service;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = -6651361697754152560L;
	
	public ItemNotFoundException(String message) {
		super(message);
	}
}

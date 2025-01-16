package com.fdmgroup.bookstore.model;

import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.service.UserNotFoundException;


public interface UserRepository<T extends User> extends Searchable<T> {

	boolean validate(String username, String password);

	User findByUsername(String username);

	@Override
	T findById(int id) throws UserNotFoundException;
}

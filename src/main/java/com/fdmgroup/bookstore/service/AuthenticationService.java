package com.fdmgroup.bookstore.service;

import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.UserRepository;

public class AuthenticationService<T extends User> {

	private UserRepository<User> userRepository;

	public AuthenticationService(UserRepository<User> userRepository) {
		this.userRepository = userRepository;
	}

	public User authenticate(String username, String password) throws UserNotFoundException {
		if (userRepository.validate(username, password)) {
			try {
				return userRepository.findByUsername(username);
			} catch (Exception e) {
				throw new UserNotFoundException("The specified User is Not Found");
			}
		}
		return null;
	}


	public User findById(int id) throws UserNotFoundException {
		try {
			return userRepository.findById(id);
		} catch (Exception e) {
			throw new UserNotFoundException("The specified User is Not Found");
		}

	}
}

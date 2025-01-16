/**
 * 
 */
package com.fdmgroup.bookstore.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.fdmgroup.bookstore.data.User;

/**
 * @author gianluca.coletti
 * @param <T>
 *
 */
public class UserArrayListRepository<T extends User> implements UserRepository<T> {

	// Global variables
	private ArrayList<T> users;
	private static final AtomicInteger count = new AtomicInteger(0);
	public final int id;

	public UserArrayListRepository() {
		this.id = generateId();
		this.users = new ArrayList<>();
	}

	/**
	 * @param users
	 */
	public UserArrayListRepository(ArrayList<T> users) {
		this.id = generateId();
		this.users = users;
	}

	/**
	 * @param user
	 * @return
	 * @return the Generic object being saved
	 */
	public T save(T user) {
		User tempUser;
		if (user instanceof User) {
			tempUser = findByUsername(((User) user).getUsername());

			if (tempUser != null) {
				remove((T) tempUser);
				save(user);
			} else {
				((User) user).setUserId(generateId());
				users.add(user);
			}
		}
		return user;
	}

	/**
	 * @param <T>
	 * @param user
	 */
	public void remove(T user) {
		users.remove(user);
	}

	/**
	 * @param username, password
	 * @return boolean flag to check validation
	 */
	public boolean validate(String username, String password) {
		for (T usr : users) {
			if ((((User) usr).getUsername()).equals(username) && (((User) usr).getPassword()).equals(password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param username
	 * @return the User object with corresponding username, otherwise null
	 */
	public User findByUsername(String username) {
		for (T usr : users) {
			if ((((User) usr).getUsername()).equals(username)) {
				return (User) usr;
			}
		}
		return null;
	}

	/**
	 * @param usrId
	 * @return the User object with corresponding userId, otherwise null
	 */
	public T findById(int usrId) {
		for (T usr : users) {
			if (((User) usr).getUserId() == usrId) {
				return usr;
			}
		}
		return null;
	}

	/**
	 * @param <T>
	 * @return the ArrayList of all User objects
	 */
	public ArrayList<T> findAll() {
		return users;
	}

	/**
	 * @return the generated userId, starting from 1
	 */
	public final int generateId() {
		return count.incrementAndGet();
	}

	/**
	 * @return the current id number
	 */
	public int getId() {
		return id;
	}

}

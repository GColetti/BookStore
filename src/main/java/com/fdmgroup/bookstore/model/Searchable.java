/**
 * 
 */
package com.fdmgroup.bookstore.model;

import java.util.ArrayList;

import com.fdmgroup.bookstore.service.ItemNotFoundException;
import com.fdmgroup.bookstore.service.UserNotFoundException;


public interface Searchable<T> {

	ArrayList<T> findAll(); 
	
	T findById(int id) throws UserNotFoundException, ItemNotFoundException;
	
}

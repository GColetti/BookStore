/**
 * 
 */
package com.fdmgroup.bookstore.model;

public interface Persistable<T> {
	
	T save(T t);
}

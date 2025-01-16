package com.fdmgroup.bookstore.model;

import java.util.ArrayList;

import com.fdmgroup.bookstore.data.Order;
import com.fdmgroup.bookstore.service.ItemNotFoundException;

public interface OrderRepository<T extends Order> extends Searchable<T>, Persistable<T>{

	@Override
	T save(T t);

	@Override
	ArrayList<T> findAll();

	@Override
	T findById(int id) throws ItemNotFoundException;

}

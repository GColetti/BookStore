package com.fdmgroup.bookstore.model;

import java.util.ArrayList;


import com.fdmgroup.bookstore.data.Book;
import com.fdmgroup.bookstore.service.ItemNotFoundException;

public interface BookRepository<T extends Book> extends Searchable<T>, Persistable<T>, Removeable<T> {

	@Override
	void remove(T t);

	@Override
	T save(T t);

	ArrayList<T> findAll();

	@Override
	T findById(int id) throws ItemNotFoundException;

}

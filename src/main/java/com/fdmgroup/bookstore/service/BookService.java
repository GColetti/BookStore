package com.fdmgroup.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.bookstore.data.Book;
import com.fdmgroup.bookstore.data.BookGenre;
import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.BookRepository;

public class BookService<T extends Book> { 

	private BookRepository<Book> bookRepository;

	public BookService(BookRepository<Book> bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	public List<Book> getBooksOfGenre(BookGenre bookGenre) {
		List<Book> bookRepoList = getAllBooks();
		List<Book> bookList = new ArrayList<Book>();

		for (Book b : bookRepoList) {
			if (b.getBookGenre() == bookGenre) {
				bookList.add(b);
			}
		}
		return bookList;
	}

	public List<Book> searchBooksByTitle(String title) {
		List<Book> bookRepoList = getAllBooks();
		List<Book> bookList = new ArrayList<Book>();

		for (Book b : bookRepoList) {
			if (b.getTitle().equals(title)) {
				bookList.add(b);
			}
		}
		return bookList;
	}

	public List<Book> searchBooksByAuthorName(String bookAuthorNameToSearch) {
		List<Book> bookRepoList = getAllBooks();
		List<Book> bookList = new ArrayList<Book>();

		for (Book b : bookRepoList) {
			if (b.getAuthor().matches("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+")) {
				bookList.add(b);
			}
		}
		return bookList;
	}

	public Book findById(int id) throws ItemNotFoundException {
		try {
			return bookRepository.findById(id);
		} catch (Exception e) {
			throw new ItemNotFoundException("The specified Item is Not Found");
		}

	}

}

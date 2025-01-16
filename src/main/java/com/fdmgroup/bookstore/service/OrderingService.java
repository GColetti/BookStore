package com.fdmgroup.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.fdmgroup.bookstore.data.Book;
import com.fdmgroup.bookstore.data.Order;
import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.BookRepository;
import com.fdmgroup.bookstore.model.OrderRepository;
import com.fdmgroup.bookstore.model.UserArrayListRepository;
import com.fdmgroup.bookstore.model.UserRepository;

public class OrderingService<T extends Order> {

	private OrderRepository<Order> orderRepository;
	private UserArrayListRepository<User> userArrayListRepository;
	private AuthenticationService<User> authenticationService;
	private BookService<Book> bookService;
	private static final AtomicInteger count = new AtomicInteger(0); 

	public OrderingService(OrderRepository<Order> orderRepository) {
		this.orderRepository = orderRepository;
		userArrayListRepository = new UserArrayListRepository<User>();
	}

	public Order placeOrder(Book book, User customer) throws ItemNotFoundException, UserNotFoundException {
		if (authenticationService.findById(customer.getUserId()) != null
				&& bookService.findById(book.getItemId()) != null) {
			return new Order(count.incrementAndGet(), book, customer);
		}
		return null;
	}

	public List<Order> placeOrders(List<Book> books, User customer)
			throws ItemNotFoundException, UserNotFoundException {
		List<Order> orderList = new ArrayList<Order>();

		for (Book b : books) {
			if (authenticationService.findById(customer.getUserId()) != null
					&& bookService.findById(b.getItemId()) != null) {
				Order order = new Order(count.incrementAndGet(), b, customer);
				orderList.add(order);
			}
		}
		return orderList;
	}

	public List<Order> getOrdersForUser(User customer) {
		return customer.getOrders();
	}

	public List<Order> getOrdersForBook(Book book) {
		List<Order> orderList = new ArrayList<Order>();
		for (User user : userArrayListRepository.findAll()) {
			for (Order o : user.getOrders()) {
				if (o.getBookOrdered() == book) {
					orderList.add(o);
				}
			}
		}
		return orderList;

	}

	public void setAuthenticationService(AuthenticationService<User> authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void setBookService(BookService<Book> bookService) {
		this.bookService = bookService;
	}
}

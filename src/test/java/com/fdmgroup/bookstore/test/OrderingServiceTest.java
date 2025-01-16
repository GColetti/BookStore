package com.fdmgroup.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fdmgroup.bookstore.data.Book;
import com.fdmgroup.bookstore.data.BookGenre;
import com.fdmgroup.bookstore.data.Order;
import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.BookRepository;
import com.fdmgroup.bookstore.model.OrderRepository;
import com.fdmgroup.bookstore.model.UserArrayListRepository;
import com.fdmgroup.bookstore.model.UserRepository;
import com.fdmgroup.bookstore.service.AuthenticationService;
import com.fdmgroup.bookstore.service.BookService;
import com.fdmgroup.bookstore.service.ItemNotFoundException;
import com.fdmgroup.bookstore.service.OrderingService;
import com.fdmgroup.bookstore.service.UserNotFoundException;

class OrderingServiceTest {

	OrderRepository<Order> orderRepositoryMock;
	OrderingService<Order> orderingServiceMock;
	OrderingService<Order> orderingService;
	ArrayList<Order> expectedOrderList;
	ArrayList<Book> expectedBookList;
	ArrayList<User> expectedUserList;
	AuthenticationService<User> authenticationService;
	UserRepository<User> userRepositoryMock;
	BookService<Book> bookService;
	BookRepository<Book> bookRepositoryMock;
	Order expectedOrder;
	Book expectedBook;
	ArrayList<Book> expectedBooks;
	User expectedUser;
	UserArrayListRepository<User> userArrayListRepositoryMock;

	@BeforeEach
	void setUp() throws Exception {
		orderRepositoryMock = Mockito.mock(OrderRepository.class);
		userRepositoryMock = Mockito.mock(UserRepository.class);
		bookRepositoryMock = Mockito.mock(BookRepository.class);
		orderingService = new OrderingService<Order>(orderRepositoryMock);
		userArrayListRepositoryMock = Mockito.mock(UserArrayListRepository.class);
		bookService = new BookService<>(bookRepositoryMock);
		authenticationService = new AuthenticationService<>(userRepositoryMock);
		expectedBook = new Book(1, 2.99, "Harry Potter", "J.K. Rowling", BookGenre.FANTASY);
		expectedUser = new User("Gianluca", "Coletti", "gianluca.coletti", "pass123", "gianluca.coletti@fdmgroup.com",
				expectedOrderList);
		expectedOrder = new Order(1, expectedBook, expectedUser);
		expectedOrderList = new ArrayList<Order>();
		expectedBookList = new ArrayList<Book>();
		orderingService.setAuthenticationService(authenticationService);
		orderingService.setBookService(bookService);
		expectedBooks = new ArrayList<Book>();
	}

	@Test
	final void testOrderingService() {
		assertNotNull(orderingService);
	}

	@Test
	final void testPlaceOrder() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(expectedUser.getUserId())).thenReturn(expectedUser);
		when(bookRepositoryMock.findById(expectedBook.getItemId())).thenReturn(expectedBook);

		// Act
		Order actualOrder = orderingService.placeOrder(expectedBook, expectedUser);

		// Asserts
		assertNotNull(actualOrder);
	}
	
	@Test
	final void testPlaceOrder_WhenUserObjectDoesNotExist() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(13)).thenReturn(expectedUser);
		when(bookRepositoryMock.findById(expectedBook.getItemId())).thenReturn(expectedBook);

		// Act
		Order actualOrder = orderingService.placeOrder(expectedBook, expectedUser);

		// Asserts
		assertNull(actualOrder);
	}
	
	@Test
	final void testPlaceOrder_WhenBookObjectDoesNotExist() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(expectedUser.getUserId())).thenReturn(expectedUser);
		when(bookRepositoryMock.findById(9)).thenReturn(expectedBook);

		// Act
		Order actualOrder = orderingService.placeOrder(expectedBook, expectedUser);

		// Asserts
		assertNull(actualOrder);
	}

	@Test
	final void testPlaceOrders() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(expectedUser.getUserId())).thenReturn(expectedUser);
		when(bookRepositoryMock.findById(expectedBook.getItemId())).thenReturn(expectedBook);
		expectedBooks.add(expectedBook);

		// Act
		List<Order> actualOrderList = orderingService.placeOrders(expectedBooks, expectedUser);

		// Asserts
		assertNotNull(actualOrderList);
	}

	@Test
	final void testGetOrdersForUser() {
		// Arrange
		when(userArrayListRepositoryMock.findAll()).thenReturn(expectedUserList);
		expectedUser.setOrders(expectedOrderList);
		
		// Act
		List<Order> actualOrderList = orderingService.getOrdersForUser(expectedUser);

		// Asserts
		assertNotNull(actualOrderList);
	}

	@Test
	final void testGetOrdersForBook() {
		// Arrange
		expectedOrderList.add(expectedOrder);
		when(userArrayListRepositoryMock.findAll()).thenReturn(expectedUserList);

		// Act
		List<Order> actualOrderList = orderingService.getOrdersForBook(expectedBook);

		// Asserts
		assertNotNull(actualOrderList);
	}

}

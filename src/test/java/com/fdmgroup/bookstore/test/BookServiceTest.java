package com.fdmgroup.bookstore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fdmgroup.bookstore.data.Book;
import com.fdmgroup.bookstore.data.BookGenre;
import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.BookRepository;
import com.fdmgroup.bookstore.service.BookService;
import com.fdmgroup.bookstore.service.ItemNotFoundException;
import com.fdmgroup.bookstore.service.UserNotFoundException;

class BookServiceTest {

	BookRepository<Book> bookRepositoryMock;
	BookService<Book> bookServiceMock;
	BookService<Book> bookService;
	ArrayList<Book> expectedBookList;
	Book expectedBook;

	@BeforeEach
	void setUp() throws Exception {
		bookRepositoryMock = Mockito.mock(BookRepository.class);
		bookService = new BookService<>(bookRepositoryMock);
		expectedBook = new Book(1, 2.99, "Harry Potter", "J.K. Rowling", BookGenre.FANTASY);
		expectedBookList = new ArrayList<Book>();
	}

	@Test
	final void testBookService() {
		assertNotNull(bookService);
	}

	@Test
	final void testGetAllBooks() {
		// Arrange
		expectedBookList.add(expectedBook);
		when(bookRepositoryMock.findAll()).thenReturn(expectedBookList);

		// Act
		List<Book> actualBookList = bookService.getAllBooks();

		// Assert
		assertEquals(expectedBookList, actualBookList);

	}

	@Test
	final void testGetBooksOfGenre() {
		// Arrange
		expectedBookList.add(expectedBook);
		when(bookRepositoryMock.findAll()).thenReturn(expectedBookList);

		// Act
		List<Book> actualBookList = bookService.getBooksOfGenre(BookGenre.FANTASY);

		// Assert
		assertEquals(expectedBookList, actualBookList);
	}

	@Test
	final void testSearchBooksByTitle() {
		// Arrange
		expectedBookList.add(expectedBook);
		when(bookRepositoryMock.findAll()).thenReturn(expectedBookList);

		// Act
		List<Book> actualBookList = bookService.searchBooksByTitle("Harry Potter");

		// Assert
		assertEquals(expectedBookList, actualBookList);
	}

	@Test
	final void testSearchBooksByAuthorName() {
		// Arrange
		expectedBookList.add(expectedBook);
		when(bookRepositoryMock.findAll()).thenReturn(expectedBookList);

		// Act
		List<Book> actualBookList = bookService.searchBooksByAuthorName("J.K. Rowling");

		// Assert
		assertEquals(expectedBookList, actualBookList);
	}

	@Test
	final void testFindById_WhenObjectDoesExist() throws ItemNotFoundException {
		// Arrange
		when(bookRepositoryMock.findById(1)).thenReturn(expectedBook);

		// Act
		Book actualBook = bookService.findById(1);

		// Assert
		assertEquals(expectedBook, actualBook);
	}

	@Test
	final void testFindById_WhenObjectDoesNotExist() throws ItemNotFoundException {
		// Arrange
		when(bookRepositoryMock.findById(anyInt())).thenReturn(expectedBook);

		// Arrange
		when(bookRepositoryMock.findById(anyInt()))
				.thenThrow(new ItemNotFoundException("The specified Item is Not Found"));

		// Act
		ItemNotFoundException exception = assertThrows(ItemNotFoundException.class, () -> {
			bookRepositoryMock.findById(anyInt());
		});
		String expectedMessage = "The specified Item is Not Found";
		String actualMessage = exception.getMessage();

		// Assert
		assertTrue(exception instanceof ItemNotFoundException);
		assertTrue(actualMessage.contains(expectedMessage));
	}

}

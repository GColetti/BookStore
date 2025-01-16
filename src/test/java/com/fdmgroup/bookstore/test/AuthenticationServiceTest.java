package com.fdmgroup.bookstore.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fdmgroup.bookstore.data.Order;
import com.fdmgroup.bookstore.data.User;
import com.fdmgroup.bookstore.model.UserRepository;
import com.fdmgroup.bookstore.service.AuthenticationService;
import com.fdmgroup.bookstore.service.ItemNotFoundException;
import com.fdmgroup.bookstore.service.UserNotFoundException;

class AuthenticationServiceTest {

	AuthenticationService<User> authenticationService;
	AuthenticationService<User> authenticationServiceMock;
	UserRepository<User> userRepositoryMock;
	User expectedUser;
	User actualUser;
	Mockito mockObj;

	@BeforeEach
	void setUp() throws Exception {
		mockObj = new Mockito();
		userRepositoryMock = Mockito.mock(UserRepository.class);
		ArrayList<Order> userOrders = new ArrayList<Order>();
		authenticationService = new AuthenticationService<User>(userRepositoryMock);
		authenticationServiceMock = Mockito.mock(AuthenticationService.class);
		expectedUser = new User("Gianluca", "Coletti", "gianluca.coletti", "pass123", "gianluca.coletti@fdmgroup.com",
				userOrders);
	}

	@Test
	@DisplayName("Test AuthenticationService Constructor")
	final void testAuthenticationService() {
		assertNotNull(authenticationService);
	}

	@Test
	@DisplayName("Test Authenticate Method when User exists")
	final void testAuthenticate_Existing() throws UserNotFoundException {

		// Arrange
		when(userRepositoryMock.validate("gianluca.coletti", "pass123")).thenReturn(true);
		when(userRepositoryMock.findByUsername("gianluca.coletti")).thenReturn(expectedUser);

		// Act
		actualUser = authenticationService.authenticate("gianluca.coletti", "pass123");

		// Assert
		assertEquals(expectedUser, actualUser);
	}

	@Test
	@DisplayName("Test Authenticate Method when User does not exist")
	final void testAuthenticate_NonExisting_ThrowUserNotFoundException() throws UserNotFoundException {
		// Arrange
		when(userRepositoryMock.validate("gianluca.coletti", "pass123")).thenReturn(true);
		when(userRepositoryMock.findByUsername("gianluca.smith")).thenReturn(null);
		when(authenticationServiceMock.authenticate(anyString(), anyString()))
				.thenThrow(new UserNotFoundException("The specified User is Not Found"));

		// Act
		UserNotFoundException exception = assertThrows(UserNotFoundException.class,
				() -> authenticationServiceMock.authenticate("gianluca.smith", "pass123"));

		String expectedMessage = "The specified User is Not Found";
		String actualMessage = exception.getMessage();

		// Assert
		assertTrue(exception instanceof UserNotFoundException);
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	@DisplayName("Test FindById when User exists")
	final void testFindById_Existing() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(0)).thenReturn(expectedUser);

		// Act
		actualUser = authenticationService.findById(0);

		// Assert
		assertEquals(expectedUser, actualUser);

	}

	@Test
	@DisplayName("Test FindById when User does not exist")
	final void testFindById_NonExisting_ThrowsUserNotFoundException() throws UserNotFoundException, ItemNotFoundException {
		// Arrange
		when(userRepositoryMock.findById(anyInt()))
				.thenThrow(new UserNotFoundException("The specified User is Not Found"));

		// Act
		UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
			userRepositoryMock.findById(anyInt());
		});
		String expectedMessage = "The specified User is Not Found";
		String actualMessage = exception.getMessage();

		// Assert
		assertTrue(exception instanceof UserNotFoundException);
		assertTrue(actualMessage.contains(expectedMessage));
	}


}

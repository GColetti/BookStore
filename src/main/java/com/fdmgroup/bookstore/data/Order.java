/**
 * 
 */
package com.fdmgroup.bookstore.data;

import java.time.LocalDateTime;

/**
 * @author gianluca.coletti
 *
 */
public class Order {
	
	// Global variables
	private int orderId;
	private Book bookOrdered;
	private User user;
	private LocalDateTime orderDateTime;

	/**
	 * No-Args Constructor
	 **/
	public Order() {
	}

	/**
	 * @param orderId
	 * @param bookOrdered
	 * @param user
	 * @param orderDateTime
	 */
	public Order(int orderId, Book bookOrdered, User user) {
		this.orderId = orderId;
		this.bookOrdered = bookOrdered;
		this.user = user;
		this.orderDateTime = LocalDateTime.now();
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the bookOrdered
	 */
	public Book getBookOrdered() {
		return bookOrdered;
	}

	/**
	 * @param bookOrdered the bookOrdered to set
	 */
	public void setBookOrdered(Book bookOrdered) {
		this.bookOrdered = bookOrdered;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the orderDateTime
	 */
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookOrdered == null) ? 0 : bookOrdered.hashCode());
		result = prime * result + ((orderDateTime == null) ? 0 : orderDateTime.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bookOrdered == null) {
			if (other.bookOrdered != null)
				return false;
		} else if (!bookOrdered.equals(other.bookOrdered))
			return false;
		if (orderDateTime == null) {
			if (other.orderDateTime != null)
				return false;
		} else if (!orderDateTime.equals(other.orderDateTime))
			return false;
		if (orderId != other.orderId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Order [orderId=%s, bookOrdered=%s, user=%s, orderDateTime=%s]", orderId, bookOrdered,
				user, orderDateTime);
	}
}

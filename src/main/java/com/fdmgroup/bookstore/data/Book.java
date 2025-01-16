/**
 * 
 */
package com.fdmgroup.bookstore.data;

/**
 * @author gianluca.coletti
 *
 */
public class Book {

	// Global variables
	private int itemId;
	private double price;
	private String title, author;
	private BookGenre bookGenre;

	/**
	 * No-Args Constructor
	 **/
	public Book() {
	}

	/**
	 * @param itemId
	 * @param price
	 * @param title
	 * @param author
	 * @param bookGenre
	 */
	public Book(int itemId, double price, String title, String author, BookGenre bookGenre) {
		this.itemId = itemId;
		this.price = price;
		this.title = title;
		this.author = author;
		this.bookGenre = bookGenre;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the bookGenre
	 */
	public BookGenre getBookGenre() {
		return bookGenre;
	}

	/**
	 * @param bookGenre the bookGenre to set
	 */
	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookGenre == null) ? 0 : bookGenre.hashCode());
		result = prime * result + itemId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookGenre != other.bookGenre)
			return false;
		if (itemId != other.itemId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Book [itemId=%s, price=%s, title=%s, author=%s, bookGenre=%s]", itemId, price, title,
				author, bookGenre);
	}
}

/**
 * 
 */
package com.fdmgroup.bookstore.data;

/**
 * @author gianluca.coletti
 *
 */
public class AudioBook extends Book {

	// Global variables
	private int timeLengthSeconds;

	/**
	 * No-Args Constructor
	 **/
	public AudioBook() {
	}

	/**
	 * @param itemId
	 * @param price
	 * @param title
	 * @param author
	 * @param bookGenre
	 * @param timeLengthSeconds
	 */
	public AudioBook(int itemId, double price, String title, String author, BookGenre bookGenre,
			int timeLengthSeconds) {
		super(itemId, price, title, author, bookGenre);
		this.timeLengthSeconds = timeLengthSeconds;
	}

	@Override
	public int getItemId() {
		return super.getItemId();
	}

	@Override
	public void setItemId(int itemId) {
		super.setItemId(itemId);
	}

	@Override
	public double getPrice() {
		return super.getPrice();
	}

	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}

	@Override
	public String getAuthor() {
		return super.getAuthor();
	}

	@Override
	public void setAuthor(String author) {
		super.setAuthor(author);
	}

	@Override
	public BookGenre getBookGenre() {
		return super.getBookGenre();
	}

	@Override
	public void setBookGenre(BookGenre bookGenre) {
		super.setBookGenre(bookGenre);
	}

	/**
	 * @return the timeLengthSeconds
	 */
	public int getTimeLengthSeconds() {
		return timeLengthSeconds;
	}

	/**
	 * @param timeLengthSeconds the timeLengthSeconds to set
	 */
	public void setTimeLengthSeconds(int timeLengthSeconds) {
		this.timeLengthSeconds = timeLengthSeconds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + timeLengthSeconds;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AudioBook other = (AudioBook) obj;
		if (timeLengthSeconds != other.timeLengthSeconds)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("AudioBook [itemId=%s, price=%s, title=%s, author=%s, bookGenre=%s, timeLengthSeconds=%s]",
				super.getItemId(), super.getPrice(), super.getTitle(), super.getAuthor(), super.getBookGenre(),
				timeLengthSeconds);
	}
}

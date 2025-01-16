/**
 * 
 */
package com.fdmgroup.bookstore.data;

/**
 * @author gianluca.coletti
 *
 */
/**
 * @author gianluca.coletti
 *
 */
public class EBook extends Book {

	// Global variables
	private double sizeMegaBytes;

	/**
	 * No-Args Constructor
	 **/
	public EBook() {
	}

	/**
	 * @param itemId
	 * @param price
	 * @param title
	 * @param author
	 * @param bookGenre
	 * @param sizeMegaBytes
	 */
	public EBook(int itemId, double price, String title, String author, BookGenre bookGenre, int sizeMegaBytes) {
		super(itemId, price, title, author, bookGenre);
		this.sizeMegaBytes = sizeMegaBytes;
	}

	/**
	 * @return the itemId
	 */
	@Override
	public int getItemId() {
		return super.getItemId();
	}

	/**
	 * @param itemId the itemId to set
	 */
	@Override
	public void setItemId(int itemId) {
		super.setItemId(itemId);
	}

	/**
	 * @return the price
	 */
	@Override
	public double getPrice() {
		return super.getPrice();
	}

	/**
	 * @param price the price to set
	 */
	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}

	/**
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return super.getTitle();
	}

	/**
	 * @param title the title to set
	 */
	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}

	/**
	 * @return the author
	 */
	@Override
	public String getAuthor() {
		return super.getAuthor();
	}

	/**
	 * @param author the author to set
	 */
	@Override
	public void setAuthor(String author) {
		super.setAuthor(author);
	}

	/**
	 * @return the bookGenre
	 */
	@Override
	public BookGenre getBookGenre() {
		return super.getBookGenre();
	}

	/**
	 * @param bookGenre the bookGenre to set
	 */
	@Override
	public void setBookGenre(BookGenre bookGenre) {
		super.setBookGenre(bookGenre);
	}

	/**
	 * @return the sizeMegaBytes
	 */
	public double getSizeMegaBytes() {
		return sizeMegaBytes;
	}

	/**
	 * @param sizeMegaBytes the sizeMegaBytes to set
	 */
	public void setSizeMegaBytes(double sizeMegaBytes) {
		this.sizeMegaBytes = sizeMegaBytes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(sizeMegaBytes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EBook other = (EBook) obj;
		if (Double.doubleToLongBits(sizeMegaBytes) != Double.doubleToLongBits(other.sizeMegaBytes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("EBook [itemId=%s, price=%s, title=%s, author=%s, bookGenre=%s, sizeMegaBytes=%s]",
				super.getItemId(), super.getPrice(), super.getTitle(), super.getAuthor(), super.getBookGenre(),
				sizeMegaBytes);
	}

}

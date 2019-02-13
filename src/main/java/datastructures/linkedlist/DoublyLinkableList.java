package datastructures.linkedlist;

public interface DoublyLinkableList {

	/**
	 * Inserts a link at the beginning of the list.
	 */
	public abstract void insertFirst(DoublyLinkable link);

	/**
	 * Inserts a link at the end of the list.
	 */
	public abstract void insertLast(DoublyLinkable link);

	/**
	 * @param newLink
	 * @param currentLink
	 */
	public abstract void insertBefore(DoublyLinkable newLink,
                                      DoublyLinkable currentLink);

	/**
	 * @param newLink
	 * @param currentLink
	 */
	public abstract void insertAfter(DoublyLinkable newLink,
                                     DoublyLinkable currentLink);

	/**
	 * @return the first link
	 */
	public abstract DoublyLinkable getFirst();

	/**
	 * @param first
	 */
	public abstract void setFirst(DoublyLinkable first);

	/**
	 * @return the last link
	 */
	public abstract DoublyLinkable getLast();

	/**
	 * @param last
	 */
	public abstract void setLast(DoublyLinkable last);

}
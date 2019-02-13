package datastructures.linkedlist;

public interface DoublyLinkable {
	
	/**
	 * @return a reference to the next link in the list.
	 */
	public abstract DoublyLinkable getNext();

	/**
	 * @param next reference to the next link in the list.
	 */
	public abstract void setNext(DoublyLinkable next);
	
	/**
	 * @return a reference to the previous link in the list.
	 */
	public abstract DoublyLinkable getPrevious();

	/**
	 * @param previous reference to the previous link in the list.
	 */
	public abstract void setPrevious(DoublyLinkable previous);

	/**
	 * @return data
	 */
	public abstract LinkData getData();

	/**
	 * @param data
	 */
	public abstract void setData(LinkData data);
}

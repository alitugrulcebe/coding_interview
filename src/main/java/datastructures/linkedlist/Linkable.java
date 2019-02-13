package datastructures.linkedlist;

public interface Linkable {

	/**
	 * @return a reference to the next link in the list.
	 */
	public abstract Linkable getNext();

	/**
	 * @param next reference to the next link in the list.
	 */
	public abstract void setNext(Linkable next);

	/**
	 * @return
	 */
	public abstract LinkData getData();

	/**
	 * @param data
	 */
	public abstract void setData(LinkData data);

}
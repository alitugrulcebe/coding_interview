package datastructures.linkedlist;

public interface DoublyQueueable {
	
	/**
	 * Pushes an item onto the front of the dequeue.
	 * @param item TODO
	 */
	public abstract void pushFront(DoublyLinkable item);
	
	/**
	 * Pushes an item onto the rear of the dequeue.
	 * @param item TODO
	 */
	public abstract void pushRear(DoublyLinkable item);
	
	/**
	 * Pops an item off the front of the dequeue.
	 * @return
	 */
	public abstract DoublyLinkable popFront();
	
	/**
	 * Pops an item off the rear of the dequeue.
	 * @return
	 */
	public abstract DoublyLinkable popRear();
	
	/**
	 * Peeks at the item at the front of the dequeue.
	 * @return
	 */
	public abstract DoublyLinkable peekFront();
	
	/**
	 * Peeks at the item at the rear of the dequeue.
	 * @return
	 */
	public abstract DoublyLinkable peekRear();
}

package datastructures.linkedlist;

public class Dequeue implements DoublyQueueable {
	
	/**
	 * Dequeue implementation is based on a doubly linked list implementation.
	 */
	protected DoublyLinkableList list;
	
	/**
	 * Internal instance.
	 */
	protected static DoublyQueueable instance;
	
	/**
	 * Application starting point.
	 * @param args Command line args.
	 */
	public static void main(String[] args){
		instance = new Dequeue();
		
		// Create some items
		DoublyLinkable linkA = new DoubleEndedLink(34, "Commander", "Shepard", "Assault Rifle");
		DoublyLinkable linkB = new DoubleEndedLink(24, "Officer", "Miranda Lawson", "Hand Cannon");
		DoublyLinkable linkC = new DoubleEndedLink(105, "Scientist", "Mordin Solus", "Omni Blade");
		DoublyLinkable linkD = new DoubleEndedLink(80, "Commando", "Garrus Vakarian", "Sniper Rifle");
		DoublyLinkable linkE = new DoubleEndedLink(279, "Officer", "Liara T'Soni", "Biotic Powers");
		
		// Push an item on the front of the dequeue
		System.out.println("PUSHING " + linkA.toString() + " onto the FRONT of the dequeue.");
		instance.pushFront(linkA);
		printState();
		
		// Pop the item at the front of the dequeue
		System.out.println("POPPING " + instance.peekFront().toString() + " from the FRONT of the dequeue.");
		instance.popFront();
		printState();
		
		// Push an item onto the back of the dequeue
		System.out.println("PUSHING " + linkA.toString() + " onto the REAR of the dequeue.");
		instance.pushRear(linkA);
		printState();
		
		// Push an item onto the front of the dequeue
		System.out.println("PUSHING " + linkB.toString() + " onto the REAR of the dequeue.");
		instance.pushFront(linkB);
	
		
		// Add an item after the rear item
		
		// Add an item before the front item
	}
	
	/**
	 * Prints the state of the dequeue at the given time.
	 */
	public static void printState(){
		System.out.println("Status: " + instance.toString());
	}
	
	/**
	 * Creates a new instance.
	 */
	public Dequeue(){ list = new DoublyLinkedList(); }	
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#pushFront(java.lang.Object)
	 */
	@Override
	public void pushFront(DoublyLinkable item) {
		list.insertFirst(item);
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#pushRear(java.lang.Object)
	 */
	@Override
	public void pushRear(DoublyLinkable item) {
		list.insertLast(item);
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#popFront()
	 */
	@Override
	public DoublyLinkable popFront() {
		
		// Get the front of the list
		DoublyLinkable front = list.getFirst();
		
		// Set the front item's next item to be the new front
		list.setFirst(front.getNext());
		
		// Return the old front
		return front;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#popRear()
	 */
	@Override
	public DoublyLinkable popRear() {
		
		// Get the rear of the list
		DoublyLinkable rear = list.getLast();
		
		// Set the rear item's previous item to be the new rear
		list.setLast(rear.getPrevious());
		
		// Return the old rear
		return rear;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#peekFront()
	 */
	@Override
	public DoublyLinkable peekFront() {
		return list.getFirst();
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyQueueable#peekRear()
	 */
	@Override
	public DoublyLinkable peekRear() {
		return list.getLast();
	}
}

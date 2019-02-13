package datastructures.linkedlist;

public class DoublyLinkedList implements DoublyLinkableList {
	
	/**
	 * Reference to the first link in the list.
	 */
	protected DoublyLinkable first;
	
	/**
	 * Reference to the last link in the list.
	 */
	protected DoublyLinkable last;
	
	/**
	 * @param args command-line arguments
	 */
	public static void main(String[] args){
		DoublyLinkableList linkedList = new DoublyLinkedList();
		DoublyLinkable linkA = new DoubleEndedLink(99, "Commander", "Shepard", "Assault Rifle");
		DoublyLinkable linkB = new DoubleEndedLink(75, "Officer", "Miranda Lawson", "Biotic Powers");
		DoublyLinkable linkC = new DoubleEndedLink(61, "Scientist", "Mordin Solus", "Omni Blade");
		linkedList.insertFirst(linkA);
		linkedList.insertFirst(linkB);
		linkedList.insertFirst(linkC);
		
		System.out.println(linkedList.toString());
	}
	
	/**
	 * Creates a new instance of DoublyLinkedList.
	 */
	public DoublyLinkedList(){
		
		// Sets the first link to null
		this.setFirst(null);
		
		// Sets the last link to null
		this.setLast(null);
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#insertFirst(com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void insertFirst(DoublyLinkable link){

		// Set the previous reference on the new link to null
		link.setPrevious(null);
		
		// Set the next reference on the new link to the first link
		link.setNext(getFirst());
		
		if(getFirst() != null){
		
			// Set the original first link's previous reference to the new link
			getFirst().setPrevious(link);
			
			// Set the linked list's first reference to the new link
			setFirst(link);
		} else {
			
			// There are no other links in the list so set as the first link
			setFirst(link);
			setLast(link);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#insertLast(com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void insertLast(DoublyLinkable link){
		
		// Set the next reference on the new link to null
		link.setNext(null);
		
		// Set the previous reference on the new link to the last link
		link.setPrevious(getLast());
		
		if(getLast() != null){
			
			// Set the original last link's next reference to the new link 
			getLast().setNext(link);
			
			// Set the list's last reference to the new link
			setLast(link); 
		} else {
			
			// There is no last link, so set the 
			setLast(link);
			setFirst(link);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#insertBefore(com.grosser.linkedlist.DoublyLinkable, com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void insertBefore(DoublyLinkable newLink, DoublyLinkable currentLink){
		
		// Set the next reference on the new link to the be the current link
		newLink.setNext(currentLink);
		
		// Set the previous reference on the new link to be the current link's previous reference
		newLink.setPrevious(currentLink.getPrevious());
		
		if(newLink.getPrevious() != null){
			
			// Set the previous link's next reference to the new link
			newLink.getPrevious().setNext(newLink);
		} else {
			
			// newLink is the new first link
			setFirst(newLink);
		}
		
		// Set the next link's previous reference to the new link
		currentLink.setPrevious(newLink);
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#insertAfter(com.grosser.linkedlist.DoublyLinkable, com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void insertAfter(DoublyLinkable newLink, DoublyLinkable currentLink){
		
		// Set the previous reference on the new link to be the current link
		newLink.setPrevious(currentLink);
		
		// Set the next reference on the new link to be the current link's next reference
		newLink.setNext(currentLink.getNext());
		
		if(newLink.getNext() != null){
		
			// Set the previous reference on the next link to be the current link
			newLink.getNext().setPrevious(newLink);
		} else {
			// newLink is the last link
			setLast(newLink);
		}
		
		// Set the next reference on the current link to be the new link
		currentLink.setNext(newLink);
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#getFirst()
	 */
	@Override
	public DoublyLinkable getFirst() {
		return first;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#setFirst(com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void setFirst(DoublyLinkable first) {
		this.first = first;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#getLast()
	 */
	@Override
	public DoublyLinkable getLast() {
		return last;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.DoublyLinkableList#setLast(com.grosser.linkedlist.DoublyLinkable)
	 */
	@Override
	public void setLast(DoublyLinkable last) {
		this.last = last;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		DoublyLinkable current = this.getFirst();
		String val = "";
		
		while(current != null){
			val += current.toString() + "\n";
			current = current.getNext();
		}
		
		return val;
	}
}

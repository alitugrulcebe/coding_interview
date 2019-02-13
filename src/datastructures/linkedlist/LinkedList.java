package datastructures.linkedlist;

public class LinkedList {
	
	/**
	 * @param args command-line arguments
	 */
	public static void main(String[] args){
		LinkedList linkedList = new LinkedList();
		Linkable linkA = new Link(99, "Commander", "Shepard", "Assault Rifle");
		Linkable linkB = new Link(75, "Officer", "Miranda Lawson", "Biotic Powers");
		Linkable linkC = new Link(61, "Scientist", "Mordin Solus", "Omni Blade");
		linkedList.insertFirst(linkA);
		linkedList.insertFirst(linkB);
		linkedList.insertFirst(linkC);
		
		System.out.println(linkedList.toString());
	}
	
	/**
	 * The first link in the list.
	 */
	protected Linkable first;
	
	/**
	 * Creates a new linked list with no links.
	 */
	public LinkedList(){
		this.setFirst(null);
	}
	
	/**
	 * Creates a new linked list with a single link.
	 * @param first The first link in the list.
	 */
	public LinkedList(Linkable first){
		this.setFirst(first);
	}

	/**
	 * @return the first link of the list
	 */
	public Linkable getFirst() {
		return first;
	}

	/**
	 * @param first
	 */
	public void setFirst(Linkable first) {
		this.first = first;
	}
	
	/**
	 * Inserts a new link at the front of the list.
	 * @param link The link to insert.
	 */
	public void insertFirst(Linkable link){
		link.setNext(this.first);
		this.setFirst(link);
	}
	
	/**
	 * Deletes the link at the front of the list.
	 */
	public void delete(){
		Linkable head = this.getFirst();
		this.setFirst(head.getNext());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Linkable current = this.getFirst();
		String val = "";
		
		while(current != null){
			val += current.toString() + "\n";
			current = current.getNext();
		}
		
		return val;
	}
	
}

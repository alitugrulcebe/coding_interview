package datastructures.linkedlist;

/**
 * Sorted linked list implementation that sorts from least to greatest.
 * @author joshuagrosser
 *
 */
public class SortedLinkedList extends LinkedList {

	public SortedLinkedList(Linkable first) {
		super(first);
	}
	
	@Override
	public void insertFirst(Linkable link) {
		// TODO Use the "key" field to sort each newly inserted link
		
		// Get the first link
		Linkable current = this.getFirst();
		
		// If the first link is null, set the first link to the argument
		if(current == null){ 
			this.setFirst(link);
		}
		// If the first link is not null, compare the first link's key and
		// the key of the link being inserted
		else{
			// If the first link is higher than the new link, set the new link
			// as the first, and the original first as the next
			if(current.getData().getKey() > link.getData().getKey()){
				
			} else {
				while(current != null && current.getData().getKey() > link.getData().getKey()){
					current = current.getNext();
					
				}
			}
			
			if(current.getNext() == null){
				if(link.getData().getKey() <= current.getData().getKey()){
					link.setNext(current);
					this.setFirst(link);
				}
			} 
			// If the new link is higher than the first link, compare to the next
			// link, and so on, until either reaching the end of the list or until
			// the next link is larger than the new link
			else {
				
			}
		}
	}
}

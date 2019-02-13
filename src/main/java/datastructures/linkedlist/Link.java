package datastructures.linkedlist;

/**
 * Represents a single link in a linked list. Contains a reference to the next link
 * plus various value objects.
 * 
 * @author joshuagrosser
 */
public class Link implements Linkable {
	
	private Linkable next = null;
	protected LinkData data = null;
	
	/**
	 * Create a new Link with a reference to the next link.
	 * 
	 * @param key data field.
	 * @param value data field.
	 * @param anotherValue data field.
	 * @param yetAnotherValue data field.
	 */
	public Link(int key, String value, String anotherValue, String yetAnotherValue){
		this.data = new LinkDataImpl(key, value, anotherValue, yetAnotherValue);
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.Linkable#getNext()
	 */
	@Override
	public Linkable getNext() {
		return next;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.Linkable#setNext(com.grosser.linkedlist.Linkable)
	 */
	@Override
	public void setNext(Linkable next) {
		this.next = next;
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.Linkable#getData()
	 */
	@Override
	public LinkData getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.Linkable#setData(com.grosser.linkedlist.LinkData)
	 */
	@Override
	public void setData(LinkData data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String comma = ", ";
		sb.append("Link contents: ");
		sb.append(this.data.getKey());
		sb.append(comma);
		sb.append(this.data.getValue());
		sb.append(comma);
		sb.append(this.data.getAnotherValue());
		sb.append(comma);
		sb.append(this.data.getYetAnotherValue());
		return sb.toString();
	}
}

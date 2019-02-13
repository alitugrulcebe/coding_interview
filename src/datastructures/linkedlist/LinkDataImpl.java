package datastructures.linkedlist;

public class LinkDataImpl implements LinkData {
	
	protected int key;
	protected String value;
	protected String anotherValue;
	protected String yetAnotherValue;
	
	public LinkDataImpl(int key, String value, String anotherValue, String yetAnotherValue){
		this.key = key;
		this.value = value;
		this.anotherValue = anotherValue;
		this.yetAnotherValue = yetAnotherValue;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#getKey()
	 */
	@Override
	public int getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#setKey(int)
	 */
	@Override
	public void setKey(int key) {
		this.key = key;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#setValue(java.lang.MySolutions.String)
	 */
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#getAnotherValue()
	 */
	@Override
	public String getAnotherValue() {
		return anotherValue;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#setAnotherValue(java.lang.MySolutions.String)
	 */
	@Override
	public void setAnotherValue(String anotherValue) {
		this.anotherValue = anotherValue;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#getYetAnotherValue()
	 */
	@Override
	public String getYetAnotherValue() {
		return yetAnotherValue;
	}

	/* (non-Javadoc)
	 * @see com.grosser.linkedlist.LinkData#setYetAnotherValue(java.lang.MySolutions.String)
	 */
	@Override
	public void setYetAnotherValue(String yetAnotherValue) {
		this.yetAnotherValue = yetAnotherValue;
	}
}

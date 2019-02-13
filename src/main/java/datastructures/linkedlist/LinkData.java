package datastructures.linkedlist;

public interface LinkData {

	/**
	 * @return
	 */
	public abstract int getKey();

	/**
	 * @param key
	 */
	public abstract void setKey(int key);

	/**
	 * @return
	 */
	public abstract String getValue();

	/**
	 * @param value
	 */
	public abstract void setValue(String value);

	/**
	 * @return another value
	 */
	public abstract String getAnotherValue();

	/**
	 * @param anotherValue
	 */
	public abstract void setAnotherValue(String anotherValue);

	/**
	 * @return yet another value
	 */
	public abstract String getYetAnotherValue();

	/**
	 * @param yetAnotherValue
	 */
	public abstract void setYetAnotherValue(String yetAnotherValue);

}
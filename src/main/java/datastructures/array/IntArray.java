package datastructures.array;

/**
 * All integer-based array classes should implement this interface. 
 * @author joshuagrosser
 */
public interface IntArray {

	/**
	 * Inserts the value at the next available index in the array.
	 * @param value The value to insert.
	 */
	public abstract void insert(int value);

	/**
	 * Attempts to delete the current value, if it exists in the array.
	 * @param value The value to delete.
	 */
	public abstract void delete(int value);

	/**
	 * Print the value of the array.
	 */
	public abstract void print();

	/**
	 * Performs a linear search to find the value in O(N) time.
	 * @param value The value to find.
	 * @return the index of the value, if found, or -1 if the value was not found.
	 */
	public abstract int contains(int value);
	
	/**
	 * Gets the value at the given index.
	 * @param index The index.
	 * @return The value at the given index.
	 */
	public abstract int get(int index);
	
	/**
	 * Gets the total size of the array, including non-populated cells.
	 * @return the total size of the array.
	 */
	public abstract int size();
	
	/**
	 * Sets the specified value at the specified index. Values already
	 * at this index will be overwritten.
	 * 
	 * @param index The index to write the value to.
	 * @param value The value to be written.
	 */
	public abstract void set(int index, int value);
	
	/**
	 * Populates the array with the given number of values.
	 * @param numValues The number of values to populate the array with.
	 */
	public abstract void populate(int numValues);
}
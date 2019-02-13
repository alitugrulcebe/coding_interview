package datastructures.array;

import java.util.Random;

public class UnsortedUniqueArray implements IntArray {
	
	protected int[] array;
	protected int count;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnsortedUniqueArray arrNums = new UnsortedUniqueArray(20);
		Random random = new Random();
		
		int lastVal = -1;
		int midVal = -1;
		int midVal2 = -1;
		
		// Insert 10 unique random numbers
		for(int i=0; i<10; i++){
			lastVal = random.nextInt(1000);
			arrNums.insert(lastVal);
			if (i == 5){ midVal = lastVal; }
			if (i == 3){ midVal2 = lastVal; }
		}
		
		arrNums.print();
		
		// Find the last inserted number
		arrNums.contains(lastVal);
		arrNums.print();
		
		// Delete a specific value
		arrNums.delete(midVal);
		arrNums.print();
		
		arrNums.delete(midVal2);
		arrNums.print();
	}
	
	/**
	 * Creates a new UnsortedUniqueArray with the specified size.
	 * @param size The size of the array to create.
	 */
	public UnsortedUniqueArray(int size) {
		// Initialize the array to the specified size
		this.array = new int[size];
		
		// Initialize the number of array elements to 0
		this.count = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.array.Array#insert(int)
	 */

	public void insert(int value){
		
		// Insert the value at the end of the array
		if(count < array.length){
			array[count] = value;
			System.out.println("Inserting value " + value + " at index " + count);
			count++;
			System.out.println("There are now " + count + " total items in the array.");
		} else {
			System.out.println("Cannot insert value - array is full!");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.array.Array#delete(int)
	 */

	public void delete(int value){
		
		// Find the location of the value to delete
		int index = contains(value);
		
		// If the value cannot be found, return
		if (index == -1){ System.out.println("Unable to find value to delete!"); return; }
		
		System.out.println("Deleting value " + value + " at index " + index);
		
		// Otherwise, loop through the values to the right and move them all to location-1
		for(int loc = index; loc < count; loc++){
			int nextVal = loc + 1;
			System.out.println("Moving value " + array[nextVal] + " from index " + nextVal + " to index " + loc);
			array[loc] = array[nextVal];
		}
		
		// Decrement the total count
		count--;
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.array.Array#print()
	 */

	public void print(){
		System.out.print("[");
		for(int index = 0; index < array.length; index++){
			System.out.print(" " + array[index]);
		}
		System.out.print("]\n");
	}
	
	/* (non-Javadoc)
	 * @see com.grosser.array.Array#find(int)
	 */

	public int contains(int value){
		for(int index = 0; index < count; index++){
			if(array[index] == value){
				System.out.println("Found value " + value + " at index " + index);
				return index;
			}
		}
		
		return -1;
	}

	/* (non-Javadoc)
	 * @see com.grosser.array.IntArray#get(int)
	 */

	public int get(int index) {
		return array[index];
	}

	/* (non-Javadoc)
	 * @see com.grosser.array.IntArray#size()
	 */

	public int size() {
		return array.length;
	}

	/* (non-Javadoc)
	 * @see com.grosser.array.IntArray#set(int, int)
	 */

	public void set(int index, int value) {
		array[index] = value;
	}


	public void populate(int numValues) {
		Random random = new Random();
		
		if(array.length < numValues){ 
			throw new IllegalArgumentException("Number of values greater than array size.");
		}
		
		// Insert 10 unique random numbers
		for(int i = 0; i < numValues; i++){
			array[i] = random.nextInt(1000);
		}
	}
}

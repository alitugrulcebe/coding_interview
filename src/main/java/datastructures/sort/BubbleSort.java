package datastructures.sort;


import datastructures.array.IntArray;

public class BubbleSort {

	/**
	 * Static bubble sort method. Pass in an array of integers to be sorted,
	 * and the method will sort the integers in O(N2) time, and then return
	 * the sorted array, where N is the number of items in the array.
	 * 
	 * @param array
	 * @return The sorted array.
	 */
	public static IntArray sort(IntArray array){
		
		System.out.print("Original array: ");
		array.print();

		// Outer Loop
		// Loop until all values have been sorted. This will be when the outer index
		// reaches 0.

		// n is the index of the last value in the array
		int n = array.size() - 1;

		// Outer loop
		for(int outer = n; outer >= 0; outer--){

			// Inner loop comparing and swapping values
			for(int inner = 0; inner < outer; inner++){

				// Inner Loop
				// Starting at index 0, compare indices 0 and 1. If 0 is bigger than 1, swap
				// the values. Then move on to indices 1 and 2, and so on, until the comparisons
				// end at indices n-1 and n. The largest value will be at the end.

				// Next, do the same loop through indices 0 through n-1. Now n and n-1 are sorted.
				// Continue looping through in this manner.

				if(array.get(inner) > array.get(inner + 1)){
					array = swap(array, inner, inner + 1);
				}
			}
			
			System.out.print("Current pass: ");
			array.print();
		}
		
		System.out.print("Sorted array: ");
		array.print();
		return array;
	}

	/**
	 * Performs a bidirectional sort using bubble sort. Carries the largest value
	 * to the right-most end of the array, then reverses and carries the smallest
	 * value to the left-most end of the array on the next pass, then reverses again
	 * on each subsequent pass until the array is fully sorted.
	 * 
	 * @param array The array to sort.
	 * @return the sorted array.
	 */
	public static IntArray sortBidirectional(IntArray array){

		System.out.print("Original array: ");
		array.print();
		
		// n is the index of the last value in the array
		int n = array.size() - 1;
		
		boolean reverse = false;
		int outerFwd = n;
		int outerBwd = 0;
		
		// Main loop
		while(outerFwd != outerBwd){
			
			if(!reverse){
				for(int inner = 0; inner < outerFwd; inner++){
					if(array.get(inner) > array.get(inner + 1)){
						array = swap(array, inner, inner + 1);
					}
				}
				
				System.out.print("Current pass: ");
				array.print();
				
				outerFwd--;
				reverse = true;
			} else {
				for(int inner = n; inner > outerBwd; inner--){
					if(array.get(inner) < array.get(inner - 1)){
						array = swap(array, inner, inner - 1);
					}
				}
				
				System.out.print("Current pass: ");
				array.print();
				
				outerBwd++;
				reverse = false;
			}
		}

		System.out.print("Sorted array: ");
		array.print();
		return array;
	}

	/**
	 * Swaps the values in the array at indices firstIndex and secondIndex.
	 * @param array The array whose values are being swapped.
	 * @param firstIndex The index of the first value to swap.
	 * @param secondIndex The index of the second value to swap.
	 * @return The array with the selected values swapped.
	 */
	protected static IntArray swap(IntArray array, int firstIndex, int secondIndex){
		int tempVal = array.get(firstIndex);
		array.set(firstIndex, array.get(secondIndex));
		array.set(secondIndex, tempVal);
		return array;
	}
}

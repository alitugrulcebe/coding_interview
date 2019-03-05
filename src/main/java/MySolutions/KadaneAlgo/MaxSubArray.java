package MySolutions.KadaneAlgo;

import java.util.Arrays;

public class MaxSubArray {

    // Function to find contiguous sub-array with the largest sum
    // in given set of integers
    public static int kadane(int[] A)
    {
        // find maximum element present in given array
        int max = Arrays.stream(A).max().getAsInt();

        // if array contains all negative values, return maximum element
        if (max < 0) {
            return max;
        }

        // stores maximum sum sub-array found so far
        int maxSoFar = 0;

        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;

        // do for each element of the given array
        for (int i: A)
        {
            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + i;

            // if maximum sum is negative, set it to 0 (which represents
            // an empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            // update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // main function
    public static void main(String[] args)
    {
        int[] A = { -8, -3, -6, -2, -5, -4 };

        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " +	kadane(A));
    }
}


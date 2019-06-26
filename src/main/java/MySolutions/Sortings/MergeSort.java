package MySolutions.Sortings;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSort {

    public static List<Integer> mergesort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
        final List<Integer> leftHalf = values.subList(0, values.size() / 2);
        final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;
        final List<Integer> merged = new ArrayList<>(left.size() + right.size());
        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }

    //#############################
    // Merge two sorted sub-arrays arr[low .. mid] and arr[mid + 1 .. high]
    public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        int k = low, i = low, j = mid + 1;

        // While there are elements in the left and right runs
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        // Don't need to copy second half

        // copy back to the original array to reflect sorted order
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }

    // Sort array arr [low..high] using auxiliary array aux
    public static void mergeSort(int[] arr, int[] aux, int low, int high) {
        // Base case
        if (high == low) {    // if run size == 1
            return;
        }

        // find mid point
        int mid = (low + ((high - low) >> 1));

        // recursively split runs into two halves until run size == 1,
        // then merge them and return back up the call chain

        mergeSort(arr, aux, low, mid);      // split / merge left  half
        mergeSort(arr, aux, mid + 1, high); // split / merge right half

        merge(arr, aux, low, mid, high);    // merge the two half runs
    }

    // Function to check if arr is sorted in ascending order or not
    public static boolean isSorted(int[] arr) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prev > arr[i]) {
                System.out.println("MergeSort Fails!!");
                return false;
            }
            prev = arr[i];
        }

        return true;
    }

    // Implementation of Merge Sort Algorithm in Java
    public static void main(String[] args) {
        int[] arr = {12, 3, 18, 24, 0, 5, -2};
        int[] aux = Arrays.copyOf(arr, arr.length);

        // sort array 'arr' using auxiliary array 'aux'
        mergeSort(arr, aux, 0, arr.length - 1);

        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }


    }
}
package MySolutions.Sortings;

import java.util.Arrays;

class QuickSort
{
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition using Lomuto partition scheme
    public static int partition(int[] a, int start, int end)
    {
        // Pick rightmost element as pivot from the array
        int pivot = a[end];

        // elements less than pivot will be pushed to the left of pIndex
        // elements more than pivot will be pushed to the right of pIndex
        // equal elements can go either way
        int pIndex = start;

        // each time we finds an element less than or equal to pivot,
        // pIndex is incremented and that element would be placed
        // before the pivot.
        for (int i = start; i < end; i++)
        {
            if (a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        // swap pIndex with Pivot
        swap(a, end, pIndex);

        // return pIndex (index of pivot element)
        return pIndex;
    }

    // Quicksort routine
    public static void quickSort(int[] a ,int start, int end)
    {
        // base condition
        if (start >= end) {
            return;
        }

        // rearrange the elements across pivot
        int pivot = partition(a, start, end);

        // recurse on sub-array containing elements less than pivot
        quickSort(a, start, pivot - 1);

        // recurse on sub-array containing elements more than pivot
        quickSort(a, pivot + 1, end);
    }

    // Implementation of quicksort algorithm in Java
    public static void main(String[] args)
    {
        int a[] = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

        quickSort(a, 0, a.length - 1);

        // print the sorted array
        System.out.println(Arrays.toString(a));
    }
}
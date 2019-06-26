package MySolutions.Array;

public class RemoveDuplicatesFromSortedArray {

    public static int[] removeDupFromSorted(int[] arr) {
        int index = 0;
        for(int i=1;i<arr.length;i++) {
            if(arr[index] != arr[i]) {
                index++;
                if(index != i)
                    arr[index] = arr[i];
            }
        }
        int[] result = new int[index+1];
        for(int i=0;i<index+1;i++)
            result[i] = arr[i];
        return result;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,1,2,3,4,4,4,5,5,6,7,8,8,8,8,9};
        int[] ints = removeDupFromSorted(arr);
        for (int i:ints)
            System.out.print(i + " ");
    }
}

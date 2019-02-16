package MySolutions.Recursion;

import java.util.Arrays;

public class ReverseArray {
    public static int[ ] reverseArr(int[ ] arr, int length)
    {
        if(length <= arr.length / 2 )
            return arr;
        else // swapping the values
        {
            int tempVal = arr[length - 1];
            arr[length - 1] = arr[arr.length - length];
            arr[arr.length - length] = tempVal;
        }
        return reverseArr(arr, length - 1);
    } // reverseArr

    public static void main(String[] args) {
        Arrays.stream(reverseArr(new int[]{1, 2, 3, 4, 5}, 5)).forEach(System.out::print);
        System.out.println();
    }
}

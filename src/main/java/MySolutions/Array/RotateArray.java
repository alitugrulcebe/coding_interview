package MySolutions.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static int[] rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;

        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] num = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(num, 3);
       for(int i:num)
           System.out.print(i + " ");
    }
}

package MySolutions.LeetCodeGoogleExplore;

import java.util.Arrays;

public class NextPermutation {
//    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//    The replacement must be in-place and use only constant extra memory.
//
//    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
//            1,2,3 → 1,3,2
//            3,2,1 → 1,2,3
//            1,1,5 → 1,5,1
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                Arrays.sort(nums,i,nums.length);
                for(int j=i;j<nums.length;j++){
                    if(nums[j]>nums[i-1]){
                        int temp=nums[i-1];
                        nums[i-1]=nums[j];
                        nums[j]=temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
}

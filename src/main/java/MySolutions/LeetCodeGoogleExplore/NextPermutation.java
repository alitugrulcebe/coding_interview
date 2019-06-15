package MySolutions.LeetCodeGoogleExplore;

import java.util.Arrays;

public class NextPermutation {
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

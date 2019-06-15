package MySolutions.Array;

import java.util.HashMap;

public class MaxSubArraySum {
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                result = Integer.max(result, i-map.get(sum-k));
            }
            map.putIfAbsent(sum,i);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,-5,-5,7,3};
        System.out.println(maxSubArrayLen(nums,10));
    }
}

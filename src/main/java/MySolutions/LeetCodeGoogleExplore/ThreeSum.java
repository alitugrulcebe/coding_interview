package MySolutions.LeetCodeGoogleExplore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

//    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//            Note:
//
//    The solution set must not contain duplicate triplets.
//
//    Example:
//
//    Given array nums = [-1, 0, 1, 2, -1, -4],
//
//    A solution set is:
//            [
//            [-1, 0, 1],
//            [-1, -1, 2]
//            ]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            // Never let i refer to the same value twice to avoid duplicates.
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    ++j;
                    // Never let j refer to the same value twice (in an output) to avoid duplicates
                    while (j < k && nums[j] == nums[j-1]) ++j;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return result;
    }
}

package MySolutions.LeetCodeFacebook;

public class RemoveDupsFromSortedArray {

     final public static int removeDuplicates(int[] nums) {
         int uniqueIndex = 0;
         for(int i = 1; i < nums.length; i++) {
             if(nums[i] != nums[uniqueIndex]) {
                 uniqueIndex++;
                 if(uniqueIndex != i) {
                     nums[uniqueIndex] = nums[i];
                 }
             }
         }
         return uniqueIndex+1;
     }

    public static void main(String[] args) {
        int [] nums = {0,1,1,1,1,2,2,3,3,4};
        //removeDuplicates(nums);

        try {
            throw new Exception("asd");
        } catch (Exception e) {

        } finally {
            System.out.println("Finally");
        }
    }
}

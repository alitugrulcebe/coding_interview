package MySolutions.General;

import java.util.Arrays;
import java.util.HashMap;


public class LeetCodeSoln {

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Two Sum Question
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numSet = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            numSet.put(target-nums[j],j);
        }

        for (int i=0;i<nums.length;i++) {
            if(numSet.keySet().contains(nums[i]) && numSet.get(nums[i])!=i) {
                return new int[]{i,numSet.get(nums[i])};
            }
        }
        return new int[]{};
    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if(l1.val<=l2.val){
            result = l1;
            result.next = mergeTwoLists(l1.next,l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCodeSoln soln = new LeetCodeSoln();
        int[] targetArr = soln.twoSum(new int[]{2,7,11,15},9);
        Arrays.stream(targetArr).forEach(System.out::print);

        ListNode node = new LeetCodeSoln.ListNode(2);
        ListNode node1 = new LeetCodeSoln.ListNode(1);
        ListNode l = node;
        for(int i=0;i<10;i++) {
            l.next = new ListNode((i*3)+4);
            l = l.next;
        }
        System.out.println();
        System.out.println("First List");
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        ListNode l1 = node1;
        for(int i=0;i<10;i++) {
            l1.next = new ListNode((2*i)+5);
            l1 = l1.next;
        }
        System.out.println();
        System.out.println("Second List");
        temp = node1;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
        System.out.println("Merge Two List");
        ListNode solnList = soln.mergeTwoLists(node,node1);
         temp = solnList;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}

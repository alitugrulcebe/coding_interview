package MySolutions.LinkList;

import MySolutions.Tree.TreeNode;

public class PrintMiddleNode {

    static void printMiddle(ListNode head)
    {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" +
                    slow_ptr.val + "] \n");
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //ListNode.printList(swapPairs(head));
        printMiddle(head);
    }
}

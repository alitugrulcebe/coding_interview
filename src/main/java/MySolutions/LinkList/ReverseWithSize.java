package MySolutions.LinkList;

import java.util.List;

public class ReverseWithSize {

    private static ListNode reverseListWithSize(ListNode head,int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverseListWithSize(next, k);

        // prev is now head of input list
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        //ListNode.printList(swapPairs(head));
        ListNode.printList(reverseListWithSize(head,3));
    }


}

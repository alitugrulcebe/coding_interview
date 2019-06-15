package MySolutions.LinkList;

public class DeleteAlternateNodes {

    static void deleteAlt(ListNode head)
    {
        if (head == null)
            return;

        ListNode prev = head;
        ListNode now = head.next;

        while (prev != null && now != null)
        {
            /* Change next link of previus node */
            prev.next = now.next;

            /* Free node */
            now = null;

            /*Update prev and now */
            prev = prev.next;
            if (prev != null)
                now = prev.next;
        }
    }

    static void deleteAltRec(ListNode head)
    {
        if (head == null)
            return;

         ListNode node = head.next;

        if (node == null)
            return;

        /* Change the next link of head */
        head.next = node.next;

        /* free memory allocated for node */
        node = null;
        /* Recursively call for the new next of head */
        deleteAltRec(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode tmp = head;
        deleteAltRec(tmp);
        ListNode.printList(tmp);

//        ListNode tmp = head;
//        deleteAlt(tmp);
//        ListNode.printList(tmp);
    }
}

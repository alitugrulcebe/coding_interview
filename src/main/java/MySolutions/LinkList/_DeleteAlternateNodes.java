package MySolutions.LinkList;

public class _DeleteAlternateNodes {

    private static void deleteAlt(ListNode head) {
        ListNode tmp = head;
        while(tmp != null) {
            ListNode next = tmp.next;
            tmp.next = next.next;
            tmp = tmp.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        deleteAlt(head);
        ListNode.printList(head);
    }


}

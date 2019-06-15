package MySolutions.LinkList;

public class RemoveLastNode {

    public static void removeLastNode(ListNode head) {
        ListNode tmp = head;
        while (tmp.next.next != null)
            tmp = tmp.next;

        tmp.next = null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        removeLastNode(head);
        ListNode.printList(head);
    }
}

package MySolutions.LinkList;

public class MoveLastElementToFront {

    public static ListNode moveLastToFront(ListNode head) {
        ListNode tmp = head;
        while(tmp.next.next != null)
            tmp = tmp.next;
        ListNode last = tmp.next;
        tmp.next = null;
        last.next = head;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newHead = moveLastToFront(head);
        ListNode.printList(newHead);
    }
}

package MySolutions.LinkList;

public class RemoveDuplicates {

    public static ListNode removeDups(ListNode head) {
        if(head.next == null)
            return head;

        removeDups(head.next);

        if(head.val == head.next.val) {
            head.next = head.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(3);

        ListNode.printList(removeDups(head));
    }
}

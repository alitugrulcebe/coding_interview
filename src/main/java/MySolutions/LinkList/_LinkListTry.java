package MySolutions.LinkList;

public class _LinkListTry {
    static ListNode reverse(ListNode head) {
        if(head.next == null)
            return head;
        ListNode l = reverse(head.next);
        ListNode tmp = l;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = head;
        head.next =  null;
        return l;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = reverse(head);
        ListNode.printList(head);
    }
}

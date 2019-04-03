package MySolutions.LinkList;

public class ListCountRec {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //ListNode.printList(swapPairs(head));
        System.out.println(count(head));
    }

    private static int count(ListNode head) {
        if(head == null)
            return 0;
        return 1+ count(head.next);
    }
}

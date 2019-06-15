package MySolutions.LinkList;

public class LinkListToString {

    public static String stringify(ListNode list) {
        return list == null ? "null" : list.val + " -> " + stringify(list.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //ListNode.printList(swapPairs(head));
        System.out.println(stringify(head));
    }
}

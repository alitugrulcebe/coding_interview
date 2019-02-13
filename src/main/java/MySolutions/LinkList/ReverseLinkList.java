package MySolutions.LinkList;

public class ReverseLinkList {

  public ListNode reverseListLeetCode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseListLeetCode(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

  public static ListNode reverseList(ListNode head) {
      if(head.next == null)
        return head;

      ListNode back = reverseList(head.next);
      ListNode tmp = back;
      while(tmp.next != null)
        tmp = tmp.next;
      tmp.next = head;
      head.next = null;

      return back;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    //ListNode.printList(swapPairs(head));
    ListNode.printList(reverseList(head));
  }
}

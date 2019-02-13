package MySolutions.LinkList;

public class SwapLinkListPairs {
  public static ListNode swapPairs(ListNode head) {
    if(head == null) {
      return head;
    }

    if(head.next != null) {
      ListNode next = head.next.next;
      ListNode tmp = head.next;
      tmp.next = head;
      head.next = next;
      tmp.next.next = swapPairs(next);
      return tmp;
    }

    return head;

  }

  public static ListNode swapNodeRecursive(ListNode head){
    if (head == null || head.next == null) {
      return head;
    }
    //change the link for first 2 nodes and
    //make a recursive call to rest of the list.
    ListNode ptrOne = head;
    ListNode ptrTwo = head.next;
    ListNode ptrTwoNext = ptrTwo.next;
    ptrTwo.next = head;
    ListNode newhead = ptrTwo;
    ptrOne.next = swapNodeRecursive(ptrTwoNext);

    return newhead;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    //ListNode.printList(swapPairs(head));
    ListNode.printList(swapNodeRecursive(head));
  }
}

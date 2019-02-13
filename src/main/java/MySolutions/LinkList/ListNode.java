package MySolutions.LinkList;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public static void printList(ListNode head) {
    ListNode tmp = head;
      while (tmp != null) {
        System.out.print(tmp.val);
        if(tmp.next != null)
          System.out.print("->");
        tmp = tmp.next;
      }
  }

}

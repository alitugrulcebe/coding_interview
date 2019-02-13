package MySolutions.General;

public class LinkList {
    class Node {
        int value;
        Node next;
        Node(int val) {
            value = val;
        }
    }

    public static void reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

            head = prev;
        }
        printList(head);
    }

    public static void removeIndex(Node head, int k) {

        Node p1 = head;
        Node p2 = head;

        while(k > 0) {
            p2 = p2.next;
            k--;
        }

        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;
        p1 = null;

        printList(head);
    }

    public static void printList(Node head) {
        Node tmp = head;
        while(tmp !=null) {
            System.out.print(tmp.value + "->");
            tmp = tmp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Node head = new LinkList().new Node(2);
        Node A = new LinkList().new Node(3);
        Node B = new LinkList().new Node(4);
        Node C = new LinkList().new Node(5);
        head.next = A;
        A.next = B;
        B.next = C;
        C.next = null;
        //reverse(head);
        removeIndex(head,2);
    }
}

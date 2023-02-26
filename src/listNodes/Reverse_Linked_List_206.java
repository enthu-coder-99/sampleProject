package listNodes;

public class Reverse_Linked_List_206 {
  public static void main(String[] args) {

    Integer i1 = 1;
    Integer i2 = 2;
    Integer i3 = 3;

    i2 = i3;
    i3 = i1;
    i1 = i2;
    System.err.println("i1=" + i1);
    System.err.println("i2=" + i2);
    System.err.println("i3=" + i3);

    ListNode listNode = ListNode.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    listNode.print();
    System.err.println(reverseList(listNode));
  }

  static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode newReversedHead = head;
    head = head.next;
    newReversedHead.next = null;
    while (head != null) {
      ListNode remainingSourceHead = head;
      head = head.next;
      remainingSourceHead.next = newReversedHead;
      newReversedHead = remainingSourceHead;
    }
    return newReversedHead;
  }

  static void reverseListWithNewHead(ListNode head, ListNode newReversedHead) {

  }
}


//1>2>3>4>5
//2>1>3>4>5







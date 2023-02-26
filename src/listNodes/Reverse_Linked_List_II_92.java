package listNodes;

import listNodes.ListNode;

public class Reverse_Linked_List_II_92 {

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

    ListNode listNode = ListNode.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    listNode.print();
    reverseBetween(listNode, 4, 6);
  }

  public static void reverseBetween(ListNode head, int left, int right) {
    ListNode firstPartHead = null;
    ListNode firstPartTail = null;

    ListNode reversedPartHead = null;
    ListNode reversedPartTail = null;
    ListNode remainingNode = head;

    int index = 1;
    while (index < left) {
      if (firstPartHead == null) {
        firstPartHead = head;
        firstPartTail = head;
      } else if (firstPartTail == null) {
        firstPartTail = head;
      } else {
        firstPartTail = head.next;
        head = head.next;
        index++;
      }
    }
    head = head.next;
  }

}

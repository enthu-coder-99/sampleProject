package listNodes;

import utils.CommonLogging;

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
    ListNode ans = reverseBetween(listNode, 4, 6);
    CommonLogging.print(ans);
    listNode = ListNode.add(new int[]{3, 5});
    ans = reverseBetween(listNode, 1, 2);
    CommonLogging.print(ans);
  }

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (right == left) return head;

    ListNode tail = head;
    ListNode preNode = null;//#1- First part of new LinkedList. This one is final.This is node# 1

    for (int i = 1; i < left - 1; i++) {
      tail = tail.next;
      preNode = tail;
    }

    System.out.println("preNode= " + (preNode != null ? preNode.val : "NULL") + ", tail=" + tail.val);

    ListNode middlePartTail = null;
    ListNode middlePartHead = null;
    tail = tail.next;//tail = 4

    for (int i = left; i <= right; i++) {// i starting with 2
      if (tail == null) continue;
      ListNode tmp_tail = tail;
      tail = tail.next;
      if (middlePartTail == null) {
        middlePartTail = tmp_tail;
        middlePartHead = tmp_tail;
        tmp_tail.next = null;
      } else {
        tmp_tail.next = middlePartHead;
        middlePartHead = tmp_tail;
      }
    }
    ListNode postPart = tail;// #3- Final and last part, This one is final.This is node# 5
    //tail--
    System.out.println("middlePartHead= " + middlePartHead.val + ", middlePartTail= " + middlePartTail + ", postPart= " + postPart.val);
    if (preNode != null)
      preNode.next = middlePartHead;
    middlePartTail.next = postPart;
    return head;
  }

}

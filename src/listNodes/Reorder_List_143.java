package listNodes;

public class Reorder_List_143 {
  public static void main(String[] args) {
    ListNode l1 = ListNode.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    reorderList(l1);
    l1 = ListNode.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    reorderList(l1);
  }

  // 11  23   35  47  59
  // 11  23   35  47  59 6null

  //13 25 37 49

  public static void reorderList(ListNode head) {
    ListNode tail = head;
    ListNode slow = head;
    ListNode fast = head;

    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    System.err.println(slow.print());
    System.err.println(fast.print());

    if (1 == 1) return;
    // By this time, slow will be in the very middle of the ListNode
    // i.e N/2 for even number of total nodes and (N+1)/2 for odd number of total nodes in orignial head.
    // Now, let us revers the slow one...
    ListNode secondHalfReversed = reverse(slow.next);
    slow.next = null;
    head = merge(head, secondHalfReversed);
  }

  public static ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode mergedListNodeHead = new ListNode(-1);
    ListNode mergedListNodeTail = mergedListNodeHead;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        mergedListNodeTail.next = l2;
        l2 = null;
      } else if (l2 == null) {
        mergedListNodeTail.next = l1;
        l1 = null;
      } else {
        ListNode tmp = l1;
        l1 = l1.next;
        tmp.next = null;
        mergedListNodeTail.next = tmp;
        mergedListNodeTail = mergedListNodeTail.next;

        tmp = l2;
        l2 = l2.next;
        tmp.next = null;
        mergedListNodeTail.next = tmp;
        mergedListNodeTail = mergedListNodeTail.next;
      }

    }
    return mergedListNodeHead.next;
  }

  public static ListNode reverse(ListNode listNode) {
    ListNode reverseListNode = null;
    while (listNode != null) {
      ListNode tmpSlow = listNode;
      listNode = listNode.next;
      tmpSlow.next = reverseListNode;
      reverseListNode = tmpSlow;
    }
    return reverseListNode;
  }
}

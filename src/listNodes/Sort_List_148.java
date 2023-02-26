package listNodes;

import java.util.ArrayList;
import java.util.List;

public class Sort_List_148 {

  public static void main(String[] args) {
    ListNode node = ListNode.add(new int[]{9, 5, 2, 0, 1, 8, 4, 3});
    System.err.println("sortList=" + sortList(node));

  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    List<ListNode> nodeList = new ArrayList<>();
    ListNode currentNode = head;
    while (currentNode != null) {
      ListNode node1 = currentNode;
      currentNode = currentNode.next;
      node1.next = null;
      nodeList.add(node1);
    }
    while (nodeList.size() > 1) {
      if (nodeList.size() > 0) {
        ListNode listNode1 = nodeList.remove(0);
        ListNode listNode2 = null;
        if (nodeList.size() > 0)
          listNode2 = nodeList.remove(0);
        nodeList.add(mergeTwoLists(listNode1, listNode2));
      }
    }
    return nodeList.get(0);
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    ListNode resultListHead = new ListNode(-1);
    ListNode resultListTail = resultListHead;

    while (list1 != null || list2 != null) {
      if (list1 == null) {
        resultListTail.next = list2;
        list2 = null;
      } else if (list2 == null) {
        resultListTail.next = list1;
        list1 = null;
      } else {
        if (list1.val > list2.val) {
          resultListTail.next = list2;
          resultListTail = resultListTail.next;
          list2 = list2.next;
        } else {
          resultListTail.next = list1;
          resultListTail = resultListTail.next;
          list1 = list1.next;
        }
      }
    }
    return resultListHead.next;
  }


}

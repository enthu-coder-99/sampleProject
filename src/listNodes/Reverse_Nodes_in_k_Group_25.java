package listNodes;

import java.util.ArrayList;
import java.util.List;

public class Reverse_Nodes_in_k_Group_25 {
  public static void main(String[] args) {
    ListNode listNode = ListNode.add(new int[]{1, 2, 3, 4, 5});
    //reverseKGroup(listNode, 2).print();
    reverseKGroup(listNode, 3).print();

  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    List<ListNode> tmpList = new ArrayList();
    ListNode current = head;
    ListNode newReversedNode = new ListNode(-1);
    ListNode currentReverseNode = newReversedNode;
    while (current != null) {
      ListNode tmp = current;
      current = current.next;
      tmp.next = null;
      tmpList.add(tmp);
      if (tmpList.size() == k) {
        for (int i = k - 1; i >= 0; i--) {
          currentReverseNode.next = tmpList.remove(i);
          currentReverseNode = currentReverseNode.next;
        }
      }
    }
    int size = tmpList.size();
    for (int i = 0; i < size; i++) {
      currentReverseNode.next = tmpList.remove(0);
      currentReverseNode = currentReverseNode.next;
    }
    return newReversedNode.next;
  }
}

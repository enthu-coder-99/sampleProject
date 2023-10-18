package listNodes;


public class Insert_into_a_Sorted_Circular_Linked_List_708 {

  public ListNode insert(ListNode head, int insertVal) {

    ListNode node = head;
    ListNode newNode = new ListNode(insertVal);

    while (node != null) {
      int node_val = node.val;
      ListNode node_next = node.next;
      int node_next_val = node_next.val;

      if (node_val == insertVal) {
        node.next = newNode;
        newNode.next = node_next;
        return head;
      }

      if (node_val < insertVal && insertVal < node_next_val) {// 3, 4, 5, __ ,8
        node.next = newNode;
        newNode.next = node_next;
        return head;
      }

      if (node_val > node_next_val) {
        // Point of cycle....
        if (insertVal > node_val || node_val < node_next_val) {
          node.next = newNode;
          newNode.next = node_next;
          return head;
        }
      }
      node = node_next;
    }
    return newNode.next = newNode;
  }
}


class Solution {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (tx == ty) break;
      if (tx > ty) {
        if (ty > sy) tx %= ty;
        else return (tx - sx) % ty == 0;
      } else {
        if (tx > sx) ty %= tx;
        else return (ty - sy) % tx == 0;
      }
    }
    return (tx == sx && ty == sy);
  }
}

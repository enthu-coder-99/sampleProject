package listNodes;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer_138 {
  public Node copyRandomList(Node head) {
    if (head == null)
      return head;
    Map<Node, Node> map = new HashMap<>();
    Node original = head;
    Node copiedNodeDummy = new Node(-1);
    Node currentCopiedNewNode = copiedNodeDummy;
    while (original != null) {
      Node newNode = new Node(original.val);
      currentCopiedNewNode.next = newNode;
      currentCopiedNewNode = currentCopiedNewNode.next;
      map.put(original, newNode);
      original = original.next;
    }

    for (Map.Entry<Node, Node> nodeMap : map.entrySet()) {
      nodeMap.getValue().random = map.get(nodeMap.getKey().random);
    }
    return copiedNodeDummy.next;
  }

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
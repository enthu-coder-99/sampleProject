package design;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Max_Stack_716 {
  public static void main(String[] args) {
    MaxStack maxStack = new MaxStack();
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(5);
    System.out.println(maxStack.top());
    System.out.println(maxStack.popMax());

  }
}

class MaxStack {

  TreeMap<Integer, List<Node>> map = new TreeMap();
  Node head = null;

  public void push(int x) {
    if (head == null) {
      Node newNode = new Node(x, null, null);
      head = newNode;
      putInMap(head);
    } else {
      Node newNode = new Node(x, null, head);
      head.prev = newNode;
      head = newNode;
      putInMap(newNode);
    }
    System.out.println("Push(), x=" + x + ", MAP=" + map + ", AND HEAD=" + head);
  }

  public int pop() {
    int valToRemove = head.val;
    head = head.next;
    head.prev = null;
    removeLastFromMap(valToRemove);
    return valToRemove;
  }

  public int top() {
    return head.val;
  }

  public int peekMax() {
    return map.lastKey();
  }

  public int popMax() {
    System.out.println("popMax()--BEFORE-- MAP=" + map + ", AND HEAD=" + head);
    Map.Entry<Integer, List<Node>> nodeEntryToRemove = map.lastEntry();
    List<Node> maxNodeList = nodeEntryToRemove.getValue();
    Node deleteNode = removeLastFromMap(nodeEntryToRemove.getKey());
    if (deleteNode == head) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
    } else {
      if (deleteNode.prev != null) {
        deleteNode.prev.next = deleteNode.next;
      }

      if (deleteNode.next != null) {
        deleteNode.next.prev = deleteNode.prev;
      }
    }

    System.out.println("popMax()--AFTER-- MAP=" + map + ", AND HEAD=" + head + ", deletedNode_val=" + deleteNode.val);

    return deleteNode.val;
  }

  private void putInMap(Node newNode) {
    int val = newNode.val;
    if (!map.containsKey(val)) {
      map.put(val, new LinkedList());
    }
    map.get(val).add(newNode);//New node in the last
  }

  private Node removeLastFromMap(int val) {
    if (map.containsKey(val)) {
      List<Node> list = map.get(val);
      Node deletedNode = list.remove(list.size() - 1);//remove all element
      if (list.size() == 0) {
        map.remove(val);
      }
      return deletedNode;
    }
    return null;
  }
}


class Node {
  public int val;
  public Node next;
  public Node prev;

  public Node(int _val, Node _prev, Node _next) {
    this.val = _val;
    this.prev = _prev;
    this.next = _next;
  }

  @Override
  public String toString() {

    String str = "Node{" +
      "val=" + val;
    Node next1 = next;
    while (next1 != null) {
      str = str + "->" + next1.val;
      next1 = next1.next;
    }

    return str;
  }
}

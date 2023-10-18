package design;

import java.util.HashMap;
import java.util.Map;

class LRU_Cache_146 {

  public static void main(String[] args) {
    LRU_Cache_146 lRUCache = new LRU_Cache_146(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.err.println(lRUCache.get(1));
    lRUCache.put(3, 3); // cache is {1=1, 2=2}
    System.err.println(lRUCache.get(2));
    lRUCache.put(4, 4); // cache is {1=1}

    System.err.println(lRUCache.get(1));
    System.err.println(lRUCache.get(3));
    System.err.println(lRUCache.get(4));
  }

  int capacity;
  CacheNode head;// Latest inserted/accessed node at front/towards the head.
  CacheNode tail;
  Map<Integer, CacheNode> map = new HashMap();

  public LRU_Cache_146(int _capacity) {
    capacity = _capacity;
    head = new CacheNode(-100, -100);
    tail = new CacheNode(-100, -100);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    CacheNode valNode = map.get(key);// Newer nodes will go in the last/tail.

    cutAndPushToEnd(valNode);
    return valNode.val;

  }

  private void cutAndPushToEnd(CacheNode valNode) {
    //   cut off the valNode
    CacheNode valNode_prev = valNode.prev;
    CacheNode valNode_next = valNode.next;

    valNode_prev.next = valNode_next;
    valNode_next.prev = valNode_prev;
    pushToEnd(valNode);

  }

  private void pushToEnd(CacheNode valNode) {
    // Push in the end
    CacheNode tail_prev = tail.prev;

    valNode.next = tail;
    tail.prev = valNode;

    tail_prev.next = valNode;
    valNode.prev = tail_prev;

  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      CacheNode valNode = map.get(key);
      cutAndPushToEnd(valNode);
      valNode.val = value;
    } else {
      if (map.size() >= capacity) {
        CacheNode nodeToDelete = head.next;
        // cut from the head..
        head.next.next.prev = head;
        head.next = head.next.next;
        // remove from the Map also.
        map.remove(nodeToDelete.key);
      }
      CacheNode newNode = new CacheNode(key, value);
      pushToEnd(newNode);
      map.put(key, newNode);
    }
  }

  public void print() {
    head.iterateFromHead();
    tail.iterateFromTail();
    System.err.println("map=" + map);
  }
}

class CacheNode {
  public Integer key;
  public Integer val;
  public CacheNode prev;
  public CacheNode next;

  public CacheNode(int key, int val) {
    this.key = key;
    this.val = val;
  }

  public String iterateFromHead() {
    CacheNode local = this;
    StringBuilder sb = new StringBuilder();
    while (local != null) {
      sb.append(local.val + ", ");
      local = local.next;
    }
    System.err.println("iterateFromHead= " + sb);
    return sb.toString();
  }

  public String iterateFromTail() {
    CacheNode local = this;
    StringBuilder sb = new StringBuilder();
    while (local != null) {
      sb.append(local.val + ", ");
      local = local.prev;
    }
    System.err.println("iterateFromTail= " + sb);
    return sb.toString();
  }

  @Override
  public String toString() {
    return val + ":";
  }
}

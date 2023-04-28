package listNodes;

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
  Map<Integer, CacheNode> cacheMap = new HashMap();

  public LRU_Cache_146(int _capacity) {
    capacity = _capacity;
    head = new CacheNode(-100, -100);
    tail = new CacheNode(100, 100);
    head.next = tail;
    tail.prev = head;
  }

  public void put(int key, int value) {
    System.err.println("-------put key=" + key + " value=" + value);
    if (cacheMap.containsKey(key)) {
      CacheNode oldNode = cacheMap.get(key);
      removeNode(oldNode);
    } else if (cacheMap.size() >= capacity) {
      CacheNode leastUsedNode = tail.prev;
      removeNode(leastUsedNode);
    }
    CacheNode newNode = new CacheNode(key, value);
    addToHead(newNode);
    cacheMap.put(key, newNode);
    print();
  }

  public int get(int key) {
    System.err.println("------get key=" + key);
    if (!cacheMap.containsKey(key)) return -1;
    CacheNode oldNode = cacheMap.get(key);
    removeNode(oldNode);
    CacheNode newNode = new CacheNode(key, oldNode.val);
    addToHead(newNode);
    cacheMap.put(key, newNode);
    print();
    return newNode.val;
  }

  public void removeNode(CacheNode node) {
    System.err.println("removeNode, removeNode.key=" + node.key + ", removeNode.val=" + node.val);
    CacheNode removedNode = cacheMap.remove(node.key);

    node.prev.next = node.next;
    node.next.prev = node.prev;
    System.err.println("Deleted from map = " + node.key + " and removedNode=" + removedNode);
  }

  // Recently used or added node will come here.
  public void addToHead(CacheNode node) {
    CacheNode head_next = head.next;
    head.next = node;
    node.prev = head;
    node.next = head_next;
    head_next.prev = node;
  }

  public void print() {
    head.iterateFromHead();
    tail.iterateFromTail();
    System.err.println("cacheMap=" + cacheMap);
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

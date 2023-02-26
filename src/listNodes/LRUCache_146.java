package listNodes;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

  Map<Integer, CacheNode> map;
  int capacity;
  CacheNode dummyHead = new CacheNode(-1, -1, null, null);
  CacheNode dummyTail = new CacheNode(-1, -1, null, null);

  public static void main(String[] args) {
    //runTestcase1();
    boolean b = false;
    if(b=true)
      System.err.println("B is true");
    if (1 == 1) return;
    LRUCache_146 lRUCache = new LRUCache_146(3);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.put(3, 3); // cache is {1=1, 2=2}
    lRUCache.put(4, 4); // cache is {1=1, 2=2}
    System.err.println(lRUCache.get(4) + " ==4");
    System.err.println(lRUCache.get(3) + " ==3");
    System.err.println(lRUCache.get(2) + " ==2");
    System.err.println(lRUCache.get(1) + " == -1");
    lRUCache.put(5, 5); // cache is {1=1}
    System.err.println(lRUCache.get(1));
    System.err.println(lRUCache.get(2));
    System.err.println(lRUCache.get(3));
    System.err.println(lRUCache.get(4));
    System.err.println(lRUCache.get(5));
  }

  public static void runTestcase1() {

    LRUCache_146 lRUCache = new LRUCache_146(2);
    iterateOver(lRUCache);

    lRUCache.put(1, 0);
    iterateOver(lRUCache);

    lRUCache.put(2, 2);
    iterateOver(lRUCache);

    System.err.println(lRUCache.get(1) + " ==0");
    iterateOver(lRUCache);

    lRUCache.put(3, 3);
    iterateOver(lRUCache);

    lRUCache.put(4, 4);
    iterateOver(lRUCache);

    System.err.println(lRUCache.get(2) + " == -1");
    iterateOver(lRUCache);

    lRUCache.put(4, 4);
    iterateOver(lRUCache);

    System.err.println(lRUCache.get(1) + " == -1");
    iterateOver(lRUCache);

    System.err.println(lRUCache.get(3) + " == 3");
    iterateOver(lRUCache);

    System.err.println(lRUCache.get(4) + " == 4");
    iterateOver(lRUCache);


  }

  public static void iterateOver(LRUCache_146 lRUCache) {
    lRUCache.dummyHead.iterateFromHead(lRUCache.dummyHead);
    lRUCache.dummyHead.iterateFromTail(lRUCache.dummyTail);
    System.err.println(lRUCache.map);
  }

  public LRUCache_146(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      CacheNode node = map.get(key);
      removeNode(node);
      node.prev = node.next = null;
      addNodeToTail(node);
      return node.val;
    }
    return -1;

  }

  public void put(int key, int value) {

    if (map.containsKey(key)) {
      CacheNode node = map.get(key);
      removeNode(node);
      node.val = value;
      addNodeToTail(node);
    } else {
      if (map.size() >= capacity) {
        CacheNode cacheNode = removeNodeFromHead();
        map.remove(cacheNode.key);
      }
      CacheNode newNode = new CacheNode(key, value, null, null);
      addNodeToTail(newNode);
      map.put(key, newNode);
    }
  }

  public CacheNode removeNodeFromHead() {
    // i.e remove the element next from head.
    CacheNode removedNode = dummyHead.next;
    if (dummyHead.next.next != null) {
      dummyHead.next.next.prev = dummyHead;
    }
    dummyHead.next = dummyHead.next.next;

    return removedNode;
  }

  public void removeNode(CacheNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void addNodeToTail(CacheNode node) {
    node.prev = dummyTail.prev;
    node.next = dummyTail;
    dummyTail.prev.next = node;
    dummyTail.prev = node;

  }

  public class CacheNode {
    int key;
    int val;
    CacheNode next;
    CacheNode prev;

    public CacheNode(int _key, int _val, CacheNode _prev, CacheNode _next) {
      key = _key;
      val = _val;
      next = _next;
      prev = _prev;
    }

    public String iterateFromHead(CacheNode node) {
      CacheNode local = node;
      StringBuilder sb = new StringBuilder();
      while (local != null) {
        sb.append(local.val + ", ");
        local = local.next;
      }
      System.err.println("iterateFromHead= " + sb);
      return sb.toString();
    }

    public String iterateFromTail(CacheNode node) {
      CacheNode local = node;
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
      return iterateFromHead(this) + iterateFromTail(this);
    }
  }
}

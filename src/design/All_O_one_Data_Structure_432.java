package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class All_O_one_Data_Structure_432 {

  public static void main(String[] args) {
    All_O_one_Data_Structure_432 obj = new All_O_one_Data_Structure_432();
    obj.inc("a");
    obj.inc("b");
    obj.inc("b");
    obj.inc("c");
    obj.inc("c");
    obj.inc("c");
    obj.dec("b");
    obj.dec("b");
    System.out.println(obj.getMinKey());
    obj.dec("a");
    System.out.println(obj.getMaxKey());
    System.out.println(obj.getMinKey());

  }

  Map<String, DataNode> strToCountMap = new HashMap();
  DataNode head = new DataNode(-1, "-1");
  DataNode tail = new DataNode(-1, "-1");

  public All_O_one_Data_Structure_432() {
    head.next = tail;
    tail.prev = head;
  }

  public void inc(String key) {
    System.out.println("1- INC and key = " + key);
    print();
    if (!strToCountMap.containsKey(key)) {
      int newCount = 1;
      DataNode newDataNode = insertNewDataNodeInRight(newCount, key, head);
      strToCountMap.put(key, newDataNode);
    } else {
      DataNode oldCountNode = strToCountMap.get(key);
      int oldCount = oldCountNode.count;
      int newCount = oldCount + 1;
      DataNode newDataNode = insertNewDataNodeInRight(newCount, key, oldCountNode);
      strToCountMap.put(key, newDataNode);

      oldCountNode.keys.remove(key);
      if (oldCountNode.keys.size() == 0) {
        deleteNode(oldCountNode);
      }
    }
    print();
  }

  public void dec(String key) {
    System.out.println("3- DEC and key = " + key);
    print();
    DataNode dataNode = strToCountMap.get(key);
    int oldCount = dataNode.count;
    int newCount = oldCount - 1;
    dataNode.keys.remove(key);

    if (newCount > 0) {
      DataNode newDataNode = insertNewDataNodeInLeft(newCount, key, dataNode);
      strToCountMap.put(key, newDataNode);
    } else {
      strToCountMap.remove(key);
    }

    if (dataNode.keys.size() == 0) {
      deleteNode(dataNode);
    }
    print();
  }

  public DataNode insertNewDataNodeInRight(int newCount, String key, DataNode oldCountNode) {
    DataNode newCountNode = null;
    if (oldCountNode.next.count == newCount) {
      newCountNode = oldCountNode.next;
      newCountNode.keys.add(key);
    } else {
      newCountNode = new DataNode(newCount, key);
      insertInMiddle(oldCountNode, newCountNode, oldCountNode.next);
    }
    return newCountNode;
  }

  public DataNode insertNewDataNodeInLeft(int newCount, String key, DataNode oldCountNode) {
    DataNode newCountNode = null;
    if (oldCountNode.prev.count == newCount) {
      newCountNode = oldCountNode.prev;
      newCountNode.keys.add(key);
    } else {
      newCountNode = new DataNode(newCount, key);
      insertInMiddle(oldCountNode.prev, newCountNode, oldCountNode);
    }
    return newCountNode;
  }

  private void insertInMiddle(DataNode left, DataNode newNode, DataNode right) {
    left.next = newNode;
    newNode.prev = left;

    newNode.next = right;
    right.prev = newNode;
  }

  private void deleteNode(DataNode dataNode) {

    dataNode.prev.next = dataNode.next;
    dataNode.next.prev = dataNode.prev;
  }

  public String getMaxKey() {
    //System.out.println("getMaxKey amd countToStrsMap = "+countToStrsMap);
    DataNode maxDataNode = tail.prev;
    if (maxDataNode == null || maxDataNode.count <= 0) return "";
    return maxDataNode.keys.iterator().next();
  }

  public String getMinKey() {
    //System.out.println("getMinKey amd countToStrsMap = "+countToStrsMap);
    DataNode minDataNode = head.next;
    if (minDataNode == null || minDataNode.count <= 0) return "";
    return minDataNode.keys.iterator().next();
  }

  public void print() {
    DataNode localNode = head;
    while (localNode != null) {
      System.out.print(localNode.toString() + "  |  ");
      localNode = localNode.next;
    }
    System.out.println();
  }

  private class DataNode {
    DataNode next;
    DataNode prev;
    int count;
    Set<String> keys;

    public DataNode(int _count, String key) {
      if (keys == null) keys = new HashSet();
      keys.add(key);
      count = _count;
    }

    @Override
    public String toString() {
      return "DataNode {" +
        " count=" + count +
        ", keys=" + keys +
        " ";
    }
  }
}


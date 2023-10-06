package design;

import java.util.Iterator;
import java.util.LinkedList;

public class Design_HashMap_706 {

  int hash = 1000;

  LinkedList<int[]>[] linkedList = new LinkedList[hash];

  public Design_HashMap_706() {
    for (int i = 0; i < hash; i++)
      linkedList[i] = new LinkedList();
  }

  public void put(int key, int value) {
    LinkedList<int[]> linkedListAtHash = getLinkedList(key);
    for (int[] keyAndVal : linkedListAtHash) {
      if (key == keyAndVal[0]) {
        keyAndVal[1] = value;
        return;
      }
    }
    linkedListAtHash.add(new int[]{key, value});
  }

  public int get(int key) {
    LinkedList<int[]> linkedListAtHash = getLinkedList(key);
    for (int[] keyAndVal : linkedListAtHash) {
      if (key == keyAndVal[0]) {
        return keyAndVal[1];
      }
    }
    return -1;
  }

  public void remove(int key) {
    LinkedList<int[]> linkedListAtHash = getLinkedList(key);
    for (Iterator<int[]> it = linkedListAtHash.iterator(); it.hasNext(); ) {
      int[] keyAndVal = it.next();
      if (key == keyAndVal[0]) {
        it.remove();
        return;
      }
    }
  }

  private LinkedList<int[]> getLinkedList(int key) {
    int keyHash = getHashCode(key);
    LinkedList<int[]> linkedListAtHash = linkedList[keyHash];
    return linkedListAtHash;
  }

  private int getHashCode(int key) {
    return key % hash;
  }

}
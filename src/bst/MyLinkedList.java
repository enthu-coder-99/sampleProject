package bst;

import bst.base.DoubleNode;

class MyLinkedList {

  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();

    list.addAtIndex(0, 10);
    list.addAtIndex(0, 20);
    list.addAtIndex(1, 30);
    System.err.println(list.get(0));
    System.err.println(list);
  }

  DoubleNode head;
  DoubleNode tail;
  int size;

  public MyLinkedList() {
  }

  public int get(int index) {
    if (index + 1 > size || index < 0) {
      return -1;
    }

    if (index > size / 2) {
      // start from tail.
      int indexFromTail = size - index - 1;
      DoubleNode currNode = tail;
      while (indexFromTail != 0) {
        currNode = currNode.previous;
        indexFromTail--;
      }
      return currNode.val;

    } else {
      return getNodeAt(index).val;
    }
  }

  public void addAtHead(int val) {
    if (head == null) {
      initializeHead(val);
    } else {
      DoubleNode newNode = new DoubleNode(val);
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
    }
    size++;
  }

  public void addAtTail(int val) {
    if (head == null) {
      initializeHead(val);
    } else {
      DoubleNode newNode = new DoubleNode(val);
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
    }
    size++;
  }

  public void addAtIndex(int index, int val) {
    if (index > size || index < 0) {
      return;
    }
    if (head == null || index == 0) {
      addAtHead(val);
    } else if (index == size) {
      addAtTail(val);
    } else {
      DoubleNode nodeAtIndex = getNodeAt(index);
      if (nodeAtIndex != null) {
        DoubleNode newNode = new DoubleNode(val);
        newNode.next = nodeAtIndex;
        newNode.previous = nodeAtIndex.previous;
        if (nodeAtIndex.previous != null)
          nodeAtIndex.previous.next = newNode;
        nodeAtIndex.previous = newNode;
        size++;
      }
    }
  }

  public void deleteAtIndex(int index) {
    if (index > size || index < 0) {
      return;
    }

    DoubleNode nodeAtIndex = getNodeAt(index);
    if (nodeAtIndex != null) {
      if (nodeAtIndex.previous != null) {
        nodeAtIndex.previous.next = nodeAtIndex.next;
      } else {
        // This is a head node deletion.
        head = nodeAtIndex.next;
      }
      if (nodeAtIndex.next != null) {
        nodeAtIndex.next.previous = nodeAtIndex.previous;
      } else {
        // This is the tail node deletion.
        tail = nodeAtIndex.previous;
      }
      size--;
    }
  }

  private DoubleNode getNodeAt(int index) {
    if (index > size || index < 0) {
      return null;
    }
    // start from Head.
    DoubleNode currNode = head;
    while (index != 0) {
      currNode = currNode.next;
      index--;
    }
    return currNode;
  }

  private void initializeHead(int val) {
    head = new DoubleNode(val);
    tail = head;
  }

}
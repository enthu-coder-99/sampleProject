package listNodes;

public class ListNode {

  public static void main(String[] args) {
    System.err.println("Helloooow");
    Integer i1 = new Integer("1");
    Integer i2 = i1;
    i1 = new Integer("2");
    System.err.println("i1=" + i1);
    System.err.println("i2=" + i2);

  }

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public String print() {
    ListNode node = this;
    if (node == null) return null;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.val + ",");
      node = node.next;
    }
    // System.err.println("Print= \n" + sb);
    return sb.toString();
  }

  public static ListNode add(int[] ints) {
    ListNode dummyNode = new ListNode(-1);
    ListNode current = dummyNode;
    for (int i = 0; i < ints.length; i++) {
      ListNode tmp = new ListNode(ints[i]);
      current.next = tmp;
      current = current.next;
    }
    return dummyNode.next;
  }


  @Override
  public String toString() {
    return print();
  }
}
package palindrome;


import listNodes.ListNode;

public class Palindrome_Linked_List_234 {
  /**
   * 1 2 3 4 5 6 7 8 9
   * slow = 1 2 3 4 5
   * fast = 1 3 5 7 9
   */

  public static void main(String[] args) {
    ListNode listNode = ListNode.add(new int[]{1, 2, 3, 4, 5, 4 , 3 , 2, 1});
    System.err.println(new Palindrome_Linked_List_234().isPalindrome(listNode));
  }

  public boolean isPalindrome(ListNode head) {
    ListNode headBackUp = head;
    ListNode slow = head;
    ListNode fast = head;
    System.err.println("0- head = " + head);
    while (slow != null && fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    System.err.println("fast = " + fast);
    System.err.println("slow = " + slow);

    ListNode reverseNode = reverseNode(slow);
    System.err.println("40- reverseNode = " + reverseNode);
    System.err.println("41- head = " + head);
    System.err.println("42- headBackUp = " + headBackUp);

    while (reverseNode != null) {
      if (reverseNode.val != headBackUp.val) return false;
      reverseNode = reverseNode.next;
      headBackUp = headBackUp.next;
    }
    return true;
  }

  public ListNode reverseNode(ListNode node) {
    System.err.println("input  node= " + node);

    ListNode listNode = null;
    while (node != null) {
      ListNode nextNode = node.next;
      if (listNode == null) {
        listNode = node;
        node.next = null;
      } else {
        node.next = listNode;
        listNode = node;
      }
      node = nextNode;
    }
    return listNode;
  }
}

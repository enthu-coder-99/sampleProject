package listNodes;

public class Remove_Nth_Node_From_Endof_List_19 {

  //1,2,3,4, 5,6,7| n=3
  // (i.e.value=5) | 14 25 36 47
  public static void main(String[] args) {
    ListNode inputNode = ListNode.add(new int[]{1});
    System.err.println(removeNthFromEnd(inputNode, 1));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < n && fast != null; i++) {
      fast = fast.next;
    }
    //Now, slow=1 fast=3 (if head = [1,2,3,4,5], n = 2)
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    // Now, slow=3 and fast=5
    // So, remove next element from slow.
    slow.next = slow.next.next;
    return head;
  }
}

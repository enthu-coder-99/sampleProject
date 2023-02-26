package listNodes;

import listNodes.ListNode;

public class AddTwoNumbers_2 {

  public static void main(String[] args) {
    System.err.println(10 / 10);
    System.err.println(10 % 10);

    System.err.println(11 / 10);
    System.err.println(11 % 10);

    System.err.println(12 / 10);
    System.err.println(12 % 10);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode resultListNode = new ListNode(0);
    ListNode tailNode = resultListNode;
    int reminder = 0;

    while (true) {
      int l1Value = 0;
      int l2Value = 0;

      if (l1 == null && l2 == null) {
        if (reminder != 0) {
          tailNode.next = new ListNode(reminder);
        }
        break;
      }
      if (l1 != null) {
        l1Value = l1.val;
      }
      if (l2 != null) {
        l2Value = l2.val;
      }

      int sum = l1Value + l2Value + reminder;
      if (sum > 9) {//10,11,12,13
        sum = sum - 10;
        reminder = 1;
      } else {
        reminder = 0;
      }


      //Find the last node/child
      ListNode newTailNode = new ListNode(sum);
      tailNode.next = newTailNode;
      tailNode = newTailNode;
      if(l1!=null)
      l1 = l1.next;
      if(l2!=null)

        l2 = l2.next;
    }
    return resultListNode.next;
  }

}

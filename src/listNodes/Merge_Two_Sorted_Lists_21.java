package listNodes;

public class Merge_Two_Sorted_Lists_21 {

  public static final String a = null;

  Merge_Two_Sorted_Lists_21() {
  }

  public static void main(String[] args) throws Exception {
    int[] int1 = {6};
    //int[] int2 = {1, 2, 3};
    int[] int2 = {6};

    ListNode listNode1 = ListNode.add(int1);
    ListNode listNode2 = ListNode.add(int2);
    ListNode resultList = mergeTwoLists(listNode1, listNode2);
    System.err.println("resultList=" + resultList);
  }


  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode mergedList = new ListNode(-1);
    ListNode mergedListTail = mergedList;
    while (list1 != null || list1 != null) {
      if (list1 == null) {
        mergedListTail.next = list2;
        list2 = null;
      } else if (list2 == null) {
        mergedListTail.next = list1;
        list1 = null;
      } else {
        if (list1.val > list2.val) {
          ListNode tmpListNode = list2;
          list2 = list2.next;
          tmpListNode.next = null;
          mergedListTail.next = tmpListNode;

        } else {
          ListNode tmpListNode = list1;
          list1 = list1.next;
          tmpListNode.next = null;
          mergedListTail.next = tmpListNode;

        }
      }
      mergedListTail = mergedListTail.next;
    }
    return mergedList.next;
  }
}

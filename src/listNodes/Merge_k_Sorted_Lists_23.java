package listNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Merge_k_Sorted_Lists_23 {

  public static void main(String[] args) {
    int[] int1 = {1, 2, 3};
    int[] int2 = {4, 5, 6};
    int[] int3 = {7, 8, 9};
    System.err.println(mergeKLists(new ListNode[]{ListNode.add(int1), ListNode.add(int2), ListNode.add(int3)}));
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;
    if (lists.length == 1)
      return lists[0];

    List<ListNode> list = Arrays.stream(lists).collect(Collectors.toCollection(ArrayList::new));

    while (list.size() >= 2) {
      ListNode mergedListNode = Merge_Two_Sorted_Lists_21.mergeTwoLists(list.remove(0), list.remove(0));
      list.add(mergedListNode);
    }
    return list.get(0);
  }

}

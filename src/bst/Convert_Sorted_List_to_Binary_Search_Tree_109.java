package bst;

import bst.base.TreeNode;
import listNodes.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

  public TreeNode sortedListToBST(ListNode head) {
    List<Integer> list = convertToList(head);
    int l = list.size();
    int mid = (l - 1) / 2;
    TreeNode rootNode = new TreeNode(list.get(mid));
    attachNode(list, rootNode, 0, mid - 1, true);
    attachNode(list, rootNode, mid + 1, l - 1, false);

    return rootNode;
  }

  private void attachNode(List<Integer> list, TreeNode parentNode, int start, int end, boolean left) {
    if (start > end) {
      return;
    }
    if (start == end) {
      if (left)
        parentNode.left = new TreeNode(list.get(start));
      else
        parentNode.right = new TreeNode(list.get(start));
      return;
    }

    int mid = start + (end - start) / 2;
    if (left) {
      parentNode.left = new TreeNode(list.get(mid));
      attachNode(list, parentNode.left, start, mid - 1, true);
      attachNode(list, parentNode.left, mid + 1, end, false);
    } else {
      parentNode.right = new TreeNode(list.get(mid));
      attachNode(list, parentNode.right, start, mid - 1, true);
      attachNode(list, parentNode.right, mid + 1, end, false);
    }
  }

  public List<Integer> convertToList(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode localHead = head;
    while (localHead != null) {
      list.add(localHead.val);
      localHead = localHead.next;
    }
    return list;
  }
}

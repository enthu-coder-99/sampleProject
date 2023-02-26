package bst;

import bst.base.TreeNode;

public class Leaf_Similar_Trees_872 {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null)
      return root1 == null && root2 == null;

    StringBuilder rootLeaveList1 = new StringBuilder();
    StringBuilder rootLeaveList2 = new StringBuilder();
    dfsNodes(root1, rootLeaveList1);
    dfsNodes(root2, rootLeaveList2);
    return rootLeaveList1.toString().equals(rootLeaveList2.toString());

  }

  private void dfsNodes(TreeNode node, StringBuilder root1LeaveStr) {
    if (node == null)
      return;

    if (node.left == null && node.right == null) {
      root1LeaveStr.append(node.val + "_");
      return;
    }
    dfsNodes(node.left, root1LeaveStr);
    dfsNodes(node.right, root1LeaveStr);
  }
}

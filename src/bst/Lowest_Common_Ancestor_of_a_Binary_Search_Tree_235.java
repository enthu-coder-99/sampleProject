package bst;

import bst.base.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (p.val > root.val && q.val > root.val)
      return lowestCommonAncestor(root.right, p, q);
    else if (p.val < root.val && q.val < root.val)
      return lowestCommonAncestor(root.left, p, q);
    return root;
  }
}
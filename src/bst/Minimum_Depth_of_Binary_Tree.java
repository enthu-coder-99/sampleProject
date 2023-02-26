package bst;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Minimum_Depth_of_Binary_Tree {

  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    return bfs(root);
  }

  private int bfs(TreeNode node) {
    if (node == null)
      return 0;
    Deque<TreeNode> queue = new ArrayDeque();
    queue.add(node);
    int level = 0;
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      while (size > 0) {
        size--;
        TreeNode treeNode = queue.pop();
        if (treeNode.left == null && treeNode.right == null)
          return level;
        if (treeNode.left != null)
          queue.offer(treeNode.left);

        if (treeNode.right != null)
          queue.offer(treeNode.right);
      }
    }
    return level;
  }
}

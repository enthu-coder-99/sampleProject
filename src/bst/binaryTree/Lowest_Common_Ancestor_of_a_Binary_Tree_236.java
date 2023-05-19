package bst.binaryTree;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1 ,2 --------- 0 , 1
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    return root;
  }

  /**
   * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65226/My-Java-Solution-which-is-easy-to-understand
   */
  public TreeNode buildChildParentMap_approach_2(TreeNode root, TreeNode p, TreeNode q) {

    if(root == null) return null;
    return root;

  }


  /**
   * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
   * Approach 2: Iterative using parent pointers
   */
  public TreeNode buildChildParentMap_approach_1(TreeNode root, TreeNode p, TreeNode q) {

    Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    childToParentMap.put(root, null);
    while (!childToParentMap.containsKey(p) || !childToParentMap.containsKey(q)) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        childToParentMap.put(node.left, node);
        queue.add(node.left);
      }

      if (node.right != null) {
        childToParentMap.put(node.right, node);
        queue.add(node.right);
      }
    }
    Set<TreeNode> p_set = new HashSet<>();
    while (p != null) {
      p_set.add(p);
      p = childToParentMap.get(p);
    }

    while (q != null) {
      if (p_set.contains(q)) return q;
      q = childToParentMap.get(q);
    }
    return root;
  }
}

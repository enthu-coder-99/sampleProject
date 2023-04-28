package bfs_dfs;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum_Width_of_Binary_Tree_662 {

  public static void main(String[] args) {

  }

  public int widthOfBinaryTree(TreeNode node) {
    int ans = 0;

    if (node == null) return ans;

    Deque<Object[]> queue = new ArrayDeque();
    queue.add(new Object[]{node, 0});

    return 0;
  }

}

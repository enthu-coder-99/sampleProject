package bst.binaryTree;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Vertical_Order_Traversal_of_a_Binary_Tree_987 {

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, List<Integer>> map = bfs(root);
    TreeSet<Integer> keySet = new TreeSet(map.keySet());
    List<List<Integer>> answer = new ArrayList<>();
    for (int verticalKey : keySet) {
      List<Integer> verticalValues = map.get(verticalKey);
      Collections.sort(new ArrayList(verticalValues));
      answer.add(verticalValues);
    }
    return answer;
  }

  public Map<Integer, List<Integer>> bfs(TreeNode root) {
    Deque<VerticalNode> deque = new ArrayDeque<>();
    deque.add(new VerticalNode(root, 0, 0));
    Map<Integer, List<Integer>> map = new HashMap<>();
    while (deque.size() > 0) {
      VerticalNode nodeObject = deque.poll();
      int x = nodeObject.x;
      int y = nodeObject.y;
      TreeNode node = nodeObject.node;
      if (!map.containsKey(y)) map.put(y, new ArrayList<>());
      map.get(y).add(node.val);
      if (node.left != null)
        deque.add(new VerticalNode(node.left, x + 1, y - 1));

      if (node.right != null)
        deque.add(new VerticalNode(node.right, x + 1, y + 1));
    }
    return map;
  }

  public class VerticalNode {
    public TreeNode node;
    public int x;
    public int y;

    public VerticalNode(TreeNode node, int x, int y) {
      this.node = node;
      this.x = x;
      this.y = y;
    }
  }
}

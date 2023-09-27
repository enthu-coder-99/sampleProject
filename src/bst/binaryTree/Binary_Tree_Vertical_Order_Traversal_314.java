package bst.binaryTree;

import bst.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Binary_Tree_Vertical_Order_Traversal_314 {

  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    TreeMap<Integer, TreeMap<Integer, List>> map = buildMap(root);
    Set<Integer> keys_y = map.keySet();
    for (int key_y : keys_y) {
      List<Integer> newSubList = new ArrayList<>();
      TreeMap<Integer, List> xAndValueMap = map.get(key_y);
      Set<Integer> keys_x = xAndValueMap.keySet();
      for (int key_x : keys_x) {
        List<Integer> values = xAndValueMap.get(key_x);
        newSubList.addAll(values);
      }
      ans.add(newSubList);
    }
    return ans;
  }

  public TreeMap<Integer, TreeMap<Integer, List>> buildMap(TreeNode root) {

    TreeMap<Integer, TreeMap<Integer, List>> map = new TreeMap();// y---> x, node
    Deque<Object[]> deque = new ArrayDeque<>();
    deque.add(new Object[]{root, 0, 0});// node, x, y
    while (deque.size() > 0) {
      Object[] nodeDetails = deque.poll();
      TreeNode node = (TreeNode) nodeDetails[0];
      int x = (int) nodeDetails[1];
      int y = (int) nodeDetails[2];
      if (!map.containsKey(y)) map.put(y, new TreeMap<>());
      if (!map.get(y).containsKey(x)) map.get(y).put(x, new ArrayList());
      map.get(y).get(x).add(node.val);
      if (node.left != null) {
        deque.add(new Object[]{node.left, x + 1, y - 1});
      }

      if (node.right != null) {
        deque.add(new Object[]{node.right, x + 1, y + 1});
      }
    }
    return map;
  }

}

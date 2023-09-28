package bst.binaryTree;


import bst.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Height_of_Binary_Tree_After_Subtree_Removal_Queries_2458 {
  Map<Integer, int[]> nodeToLevelAndHeightMap = new HashMap<>();// Node value to Level and depth Map
  Map<Integer, List<Integer>> levelToNodesMap = new HashMap<>();

  public int[] treeQueries(TreeNode root, int[] queries) {
    int l = queries.length;
    int[] ans = new int[l];
    buildTraversalMap(root, 0);
    for (int i = 0; i < l; i++) {
      int node_q = queries[i];
      int[] levelAndHt = nodeToLevelAndHeightMap.get(node_q);
      int level = levelAndHt[0];
      List<Integer> cousinsNode = levelToNodesMap.get(level);
      if (cousinsNode == null || cousinsNode.size() <= 1) {
        ans[i] = level - 1;
      } else {
        ans[i] = level;
        for (int cousin : cousinsNode) {
          if (cousin == node_q) continue;
          ans[i] = Math.max(ans[i], level + nodeToLevelAndHeightMap.get(cousin)[1]);
        }

      }
    }
    return ans;
  }


  public int buildTraversalMap(TreeNode node, int level) {
    if (node == null) return 0;
    int val = node.val;
    nodeToLevelAndHeightMap.put(val, new int[2]);
    nodeToLevelAndHeightMap.get(val)[0] = level;// Level Set

    levelToNodesMap.putIfAbsent(level, new ArrayList<>());
    levelToNodesMap.get(level).add(val);

    int leftHt = buildTraversalMap(node.left, level + 1);
    int rightHt = buildTraversalMap(node.right, level + 1);

    nodeToLevelAndHeightMap.get(val)[1] = Math.max(leftHt, rightHt);// Level Set

    return 1 + Math.max(leftHt, rightHt);
  }


}

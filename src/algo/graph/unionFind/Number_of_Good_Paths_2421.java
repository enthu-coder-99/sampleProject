package algo.graph.unionFind;

import algo.graph.util.AdjListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Number_of_Good_Paths_2421 {

  public static void main(String[] args) {
    Number_of_Good_Paths_2421 obj = new Number_of_Good_Paths_2421();
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    int[] vals = {1, 3, 2, 1, 3};
    System.out.println("Final ans = " + obj.numberOfGoodPaths(vals, edges));
  }

  public static int numberOfGoodPaths(int[] vals, int[][] edges) {
    int n = vals.length;
    UnionFindTemplate um = new UnionFindTemplate(n);
    Map<Integer, List<Integer>> adjacencyList = AdjListUtil.getAdjList(edges);

    TreeMap<Integer, List<Integer>> nodeValueToNodeIndexMap = new TreeMap();

    for (int i = 0; i < vals.length; i++) {
      int val = vals[i];
      if (!nodeValueToNodeIndexMap.containsKey(val)) nodeValueToNodeIndexMap.put(val, new ArrayList<>());
      nodeValueToNodeIndexMap.get(val).add(i);
    }
    int final_ans = 0;
    for (int nodeValue : nodeValueToNodeIndexMap.keySet()) {
      int localAns = 0;
      int connectedEdgesCount = bfs(nodeValue, nodeValueToNodeIndexMap, vals, adjacencyList, um);
      localAns = localAns + connectedEdgesCount;
      final_ans = final_ans + localAns;
      System.out.println("FINAL: nodeValue = " + nodeValue + ", localAns= " + localAns + ", connectedEdgesCount= " + connectedEdgesCount + ", final_ans=" + final_ans);
      AdjListUtil.iterateOverUMParents(um);
    }
    return final_ans;
  }

  public static int bfs(int pathMaxVal, TreeMap<Integer, List<Integer>> nodeValueToNodeIndexMap, int[] node_vals, Map<Integer, List<Integer>> adjacencyList, UnionFindTemplate um) {

    List<Integer> nodeIndexesListWithSameNodeVal = nodeValueToNodeIndexMap.get(pathMaxVal);
    System.out.println("BFS= pathMaxVal= " + pathMaxVal + ", nodeIndexesListWithSameNodeVal_size= " + nodeIndexesListWithSameNodeVal);
    for (int nodeIndexWithSameNodeVal : nodeIndexesListWithSameNodeVal) {
      if (node_vals[nodeIndexWithSameNodeVal] > pathMaxVal) continue;
      List<Integer> childrenNodes = adjacencyList.get(nodeIndexWithSameNodeVal);
      if (childrenNodes == null) continue;

      for (int childNode : childrenNodes) {
        if (node_vals[childNode] > pathMaxVal) continue;
        if (um.merge(nodeIndexWithSameNodeVal, childNode)) {
        }
      }
    }
    int size = nodeIndexesListWithSameNodeVal.size();

    int ans = 0;
    // check if these startNodesIndexList are connected. If yes, increment the ans;

    Map<Integer, Integer> nodeValueComponentParentCountMap = new HashMap<>();
    for (int i = 0; i < nodeIndexesListWithSameNodeVal.size(); i++) {
      int nodeIndex = nodeIndexesListWithSameNodeVal.get(i);
      int parent = um.findParent(nodeIndex);
      nodeValueComponentParentCountMap.put(parent, nodeValueComponentParentCountMap.getOrDefault(parent, 0) + 1);
    }

    for (int parentNode : nodeValueComponentParentCountMap.keySet()) {
      int countHavingSameParent = nodeValueComponentParentCountMap.get(parentNode);
      ans = ans + (countHavingSameParent * (countHavingSameParent + 1) / 2);
    }
    return ans;
  }
}

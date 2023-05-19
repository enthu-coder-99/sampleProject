package algo.graph.Kruskal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Number_of_Good_Paths_2421 {

  public static void main(String[] args) {
    int[] vals = new int[]{1, 3, 2, 1, 3};
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
   // vals = new int[]{1, 1, 2, 2, 3};
    //edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}};
    System.err.println(numberOfGoodPaths(vals, edges));
  }

  public static int numberOfGoodPaths(int[] vals, int[][] edges) {
    int n = vals.length;
    UnionMerge um = new UnionMerge(n);
    Map<Integer, List<Integer>> adjacencyList = UnionMerge.getAdjacencyList(edges);

    TreeMap<Integer, List<Integer>> nodeValueToIndexMap = new TreeMap();

    for (int i = 0; i < vals.length; i++) {
      int val = vals[i];
      if (!nodeValueToIndexMap.containsKey(val)) nodeValueToIndexMap.put(val, new ArrayList<>());
      nodeValueToIndexMap.get(val).add(i);
    }
    int ans = 0;
    for (int nodeValue : nodeValueToIndexMap.keySet()) {
      List<Integer> nodeIndexesListWithSameNodeVal = nodeValueToIndexMap.get(nodeValue);
      for (int i = 0; i < nodeIndexesListWithSameNodeVal.size(); i++) {
        int nodeIndex = nodeIndexesListWithSameNodeVal.get(i);
        if(!adjacencyList.containsKey(nodeIndex)) continue;
        for (int neighbourNodeIndex : adjacencyList.get(nodeIndex)) {
          if (vals[neighbourNodeIndex] > nodeValue)
            continue;// If "Neighbour" node value is more than "currentNode" node value then continue.
          boolean merged = um.merge(nodeIndex, neighbourNodeIndex);
          System.err.println("nodeValue = " + nodeValue + ", nodeIndex = " + nodeIndex + " neighbourNodeIndex = " + neighbourNodeIndex
            + " merged = " + merged + ", neighbourNodeIndex_parent = " + um.findParent(neighbourNodeIndex + 1) + ", parent_nodeIndex = " + um.findParent(nodeIndex + 1));
        }
      }
      // Calculate the parent of nodes havaing nodeValue as their value. Calculate parent of each node haivng nodeValue.
      // WE will see how many companents are there having NodeValue.
      Map<Integer, Integer> nodeValueComponentParentCountMap = new HashMap<>();
      for (int i = 0; i < nodeIndexesListWithSameNodeVal.size(); i++) {
        int nodeIndex = nodeIndexesListWithSameNodeVal.get(i);
        int parent = um.findParent(nodeIndex + 1);
        System.err.println("nodeIndex = " + nodeIndex + " and parent= " + parent);
        nodeValueComponentParentCountMap.put(parent, nodeValueComponentParentCountMap.getOrDefault(parent, 0) + 1);
      }

      for (int parentNode : nodeValueComponentParentCountMap.keySet()) {
        int countHavingSameParent = nodeValueComponentParentCountMap.get(parentNode);
        System.err.println("countHavingSameParent = " + countHavingSameParent);
        ans = ans + (countHavingSameParent * (countHavingSameParent + 1) / 2);
        System.err.println("ANS= " + ans);
      }
    }
    return ans;
  }
}

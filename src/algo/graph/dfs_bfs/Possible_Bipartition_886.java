package algo.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Possible_Bipartition_886 {

  public boolean possibleBipartition(int n, int[][] dislikes) {
    return true;
  }

  public Map<Integer, List<Integer>> getGraph(int[][] dislikes) {
    Map<Integer, List<Integer>> graph = new HashMap();

    for (int i = 0; i < dislikes.length; i++) {
      int[] dislike = dislikes[i];
      int part_1 = dislike[0];
      int part_2 = dislike[1];
      if (!graph.containsKey(part_1)) graph.put(part_1, new ArrayList());
      if (!graph.containsKey(part_2)) graph.put(part_2, new ArrayList());
      graph.get(part_1).add(part_2);
      graph.get(part_2).add(part_1);

    }
    return graph;
  }
}

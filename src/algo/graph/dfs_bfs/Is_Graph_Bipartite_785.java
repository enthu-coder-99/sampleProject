package algo.graph.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Is_Graph_Bipartite_785 {

  public static void main(String[] args) {
    int[][] input = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};//false

    input = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};//true
    input = new int[][]{{1}, {0, 3}, {3}, {1, 2}};//true
    input = new int[][]{{4, 8, 10, 12, 16, 17, 18, 19},
      {7, 9, 17, 18, 19},
      {4, 12, 16, 17, 19},
      {6, 12, 14},
      {0, 2},
      {6, 10, 11, 18, 19},
      {3, 5, 9, 17, 18},
      {1, 8, 10, 11, 12, 13, 15, 19},
      {0, 7, 15, 17, 18, 19},
      {1, 6, 10, 11, 12, 14, 17},
      {0, 5, 7, 9, 11, 12, 14},
      {5, 7, 9, 10, 15, 19},
      {0, 2, 3, 7, 9, 10, 13, 18},
      {7, 12, 15, 16, 19},
      {3, 9, 10, 17},
      {7, 8, 11, 13},
      {0, 2, 13, 17},
      {0, 1, 2, 6, 8, 9, 14, 16, 18},
      {0, 1, 5, 6, 8, 12, 17},
      {0, 1, 2, 5, 7, 8, 11, 13},
      {4, 8, 10, 12, 16, 17, 18, 19},
      {7, 9, 17, 18, 19},
      {4, 12, 16, 17, 19},
      {6, 12, 14},
      {0, 2},
      {6, 10, 11, 18, 19},
      {3, 5, 9, 17, 18},
      {1, 8, 10, 11, 12, 13, 15, 19},
      {0, 7, 15, 17, 18, 19},
      {1, 6, 10, 11, 12, 14, 17},
      {0, 5, 7, 9, 11, 12, 14},
      {5, 7, 9, 10, 15, 19},
      {0, 2, 3, 7, 9, 10, 13, 18},
      {7, 12, 15, 16, 19},
      {3, 9, 10, 17},
      {7, 8, 11, 13},
      {0, 2, 13, 17},
      {0, 1, 2, 6, 8, 9, 14, 16, 18},
      {0, 1, 5, 6, 8, 12, 17},
      {0, 1, 2, 5, 7, 8, 11, 13}};


    System.err.println(new Is_Graph_Bipartite_785().isBipartite(input));
  }

  public boolean isBipartite(int[][] graph) {
    int l = graph.length;
    int[] color = new int[l];
    // -1 - RED , +1 - BLUE, 0- No color
    for (int i = 0; i < l; i++) {
      if (color[i] != 0)
        continue;// It is already processed and kind of  Memo so will not process again. It is going to be a brand new segment of nodes.
      color[i] = -1;// Color with RED
      Deque<Integer> deque = new ArrayDeque<>();
      deque.add(i);
      while (deque.size() > 0) {
        int node = deque.poll();
        int[] neighbours = graph[node];
        for (int j = 0; j < neighbours.length; j++) {
          System.err.println("node=" + i + " and j=" + j);
          if (color[graph[node][j]] == 0) {
            color[graph[node][j]] = -1 * color[node];
            deque.add(graph[node][j]);
          } else if (color[graph[node][j]] == color[node]) {
            return false;
          }
        }
      }
    }
    return true;

  }

}

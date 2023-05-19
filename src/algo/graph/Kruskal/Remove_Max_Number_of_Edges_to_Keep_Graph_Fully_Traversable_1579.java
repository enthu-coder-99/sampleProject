package algo.graph.Kruskal;

public class Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable_1579 {


  public static void main(String[] args) {
    int n = 4;
    int[][] edges = new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
    System.out.println(maxNumEdgesToRemove(n, edges));
  }

  public static int maxNumEdgesToRemove(int n, int[][] edges) {
    UnionMerge aliceUM = new UnionMerge(n + 1);
    UnionMerge bobUM = new UnionMerge(n + 1);
    int totalEdge = edges.length;
    int totalCompCount = n;
    int totalEdgeUsed = 0;
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      int type = edge[0];
      if (type == 3) {
        int from = edge[1];
        int to = edge[2];
        if (aliceUM.merge(from, to) | bobUM.merge(from, to)) {
          totalEdgeUsed++;
        }
      }
    }

    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      int type = edge[0];
      int from = edge[1];
      int to = edge[2];
      if (type == 1 && aliceUM.merge(from, to)) {
        totalEdgeUsed++;
      } else if (type == 2 && bobUM.merge(from, to)) {
        totalEdgeUsed++;
      }
    }

    if (aliceUM.numberOfComponents() == 1 && bobUM.numberOfComponents() == 1) {
      return totalEdge - totalEdgeUsed;
    }
    return -1;
  }
}

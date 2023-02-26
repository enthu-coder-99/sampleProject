package algo.graph.unionFind;

public class Redundant_Connection_684 {

  public int[] findRedundantConnection(int[][] edges) {
    int l = edges.length;
    UnionFind uf = new UnionFind(l);
    int[] result = new int[2];
    for (int[] edge : edges) {
      boolean merge = uf.merge(edge[0], edge[1]);
      if (!merge) result = edge;
    }
    return result;
  }

  public class UnionFind {
    int n;
    int[] parents;
    int[] size;

    public UnionFind(int _n) {
      n = _n;
      parents = new int[n + 1];
      size = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parents[i] = i;
        size[i] = 1;
      }
    }

    public int findParent(int node) {
      if (node == parents[node])
        return node;
      return parents[node] = findParent(parents[node]);
    }


    public boolean merge(int node1, int node2) {
      int node1_ultimateParent = findParent(node1);
      int node2_ultimateParent = findParent(node2);
      if (node1_ultimateParent == node2_ultimateParent) return false;
      if (size[node2_ultimateParent] > size[node1_ultimateParent]) {
        //Attach node1 to node2
        size[node2_ultimateParent] += size[node1_ultimateParent];
        parents[node1_ultimateParent] = node2_ultimateParent;
      } else {
        size[node1_ultimateParent] += size[node2_ultimateParent];
        parents[node2_ultimateParent] = node1_ultimateParent;
      }
      return true;
    }
  }

}

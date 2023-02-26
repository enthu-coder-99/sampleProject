package algo.graph.unionFind;

public class Number_of_Provinces_547 {

  public static void main(String[] args) {
    System.err.println("fdf");
    System.err.println(String.valueOf(3).length());
  }

  public int findCircleNum(int[][] isConnected) {
    int l = isConnected.length;
    UnionFind unionFind = new UnionFind(l);
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        if (isConnected[i][j] == 1) {
          unionFind.merge(i, j);
        }
      }
    }
    System.err.println(unionFind.getCount());
    return unionFind.getCount();
  }

   class UnionFind {
    public int[] parent;
    public int[] size;
    int count;

    /**
     * https://www.youtube.com/watch?v=wU6udHRIkcc
     * https://www.youtube.com/watch?v=aBxjDBC4M1U
     *
     * @param n
     */
    public UnionFind(int n) {
      parent = new int[n + 1];
      size = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
        count = n;
      }
    }

    int findParent(int val) {
      if (parent[val] == val) return parent[val];
      else
        return parent[val] = findParent(parent[val]);// path Compression
    }

    void merge(int n1, int n2) {
      System.err.println("merging n1=" + n1 + " and n2=" + n2);
      int parent_n1 = findParent(n1);
      int parent_n2 = findParent(n2);
      System.err.println("parent_n1 = " + parent_n1 + " and parent_n2 = " + parent_n2);
      if (parent_n1 == parent_n2) return;
      if (size[parent_n1] > size[parent_n2]) {
        System.err.println("Adding n1 to n2");
        size[parent_n1] += size[parent_n2];
        parent[parent_n2] = parent_n1;
      } else {
        System.err.println("Adding n2 to n1");
        size[parent_n2] += size[parent_n1];
        parent[parent_n1] = parent_n2;
      }
      count--;
    }

    public int getCount() {
      return count;
    }
  }

}

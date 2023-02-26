package algo.graph.unionFind;

public class UnionFindTemplate {
  public int[] parent;
  public int[] size;
  int count;

  /**
   * https://www.youtube.com/watch?v=wU6udHRIkcc
   * https://www.youtube.com/watch?v=aBxjDBC4M1U
   *
   * @param n
   */
  public UnionFindTemplate(int n) {
    parent = new int[n + 1];
    size = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;// everyone is parent of itself.
      size[i] = 1; // Every is single/alone initially.
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
      System.err.println("Adding n2 to n1");
      size[parent_n1] += size[parent_n2];
      parent[parent_n2] = parent_n1;
    } else {
      System.err.println("Adding n1 to n2");
      size[parent_n2] += size[parent_n1];
      parent[parent_n1] = parent_n2;
    }
    count--;
  }

  public int getCount() {
    return count;
  }

}

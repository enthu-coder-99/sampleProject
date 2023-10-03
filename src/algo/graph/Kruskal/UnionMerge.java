package algo.graph.Kruskal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class UnionMerge {
  public int n;
  public int[] parent;
  public int[] size;

  public UnionMerge(int _n) {
    n = _n + 1;// Increment by '1' so that we can avoid confusion with node value = 0. otherwise "0" will always to parents of itself.
    parent = new int[n];
    size = new int[n];
    for (int i = 1; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int findParent(int cand) {
    if (parent[cand] == cand) return cand;
    return parent[cand] = findParent(parent[cand]);
  }

  public static int findParentByParentArray(int cand, int[] parentArray) {
    if (parentArray[cand] == cand) return cand;
    return parentArray[cand] = findParentByParentArray(parentArray[cand], parentArray);
  }

  public boolean isAlreadyConnected(int c1, int c2) {
    c1++;
    c2++;
    int c1_p = findParent(c1);
    int c2_p = findParent(c2);
    if (c1_p == c2_p) return true;
    return false;
  }

  public boolean merge(int c1, int c2) {
    // System.err.println("c1=" + c1 + ", c2=" + c2);
    c1++;
    c2++;
    //CommonLogging.printArray(parent);
    int c1_p = findParent(c1);
    //CommonLogging.printArray(parent);

    int c2_p = findParent(c2);
    //CommonLogging.printArray(parent);

    if (c1_p == c2_p) return false;
    if (size[c1_p] > size[c2_p]) {
      parent[c2_p] = c1_p;
      size[c1_p] += size[c2_p];
    } else {
      parent[c1_p] = c2_p;
      size[c2_p] += size[c1_p];
    }
    return true;
  }

  // Component should start with "1"
  public int numberOfComponents() {
    int comp = 0;
    for (int i = 1; i < parent.length; i++) {
      if (i == parent[i]) comp++;
    }
    return comp;
  }
}

package algo.graph.unionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Number_of_Operations_to_Make_Network_Connected_1319 {

  public int makeConnected(int n, int[][] connections) {
    int l = connections.length;
    if (l < n - 1) return -1;
    Arrays.sort(connections, (c1, c2) -> (c1[0] - c2[0]) == 0 ? (c1[1] - c2[1]) : (c1[0] - c2[0]));
    TreeMap<Integer, List<Integer>> map1 = new TreeMap();
    TreeMap<Integer, List<Integer>> map2 = new TreeMap();

    for (int[] con : connections) {
      System.out.println(con[0] + "--->" + con[1] + "-");
      if (!map1.containsKey(con[0])) map1.put(con[0], new LinkedList());
      if (!map2.containsKey(con[1])) map2.put(con[1], new LinkedList());
      map1.get(con[0]).add(con[1]);
      map2.get(con[1]).add(con[0]);

    }
    System.err.println("---------");
    Set<Integer> set1 = map1.keySet();
    Set<Integer> set2 = map2.keySet();
    for (Integer k1 : set1) {
      System.out.println(k1 + " # " + map1.get(k1));
    }
    System.err.println("---------");

    for (Integer k2 : set2) {
      System.out.println(k2 + " # " + map2.get(k2));
    }

    UnionFind uf = new UnionFind(n);
    int extraConnection = 0;
    Set<Integer> connected = new HashSet();
    for (int i = 0; i < l; i++) {
      int[] connection = connections[i];
      int from = connection[0];
      int to = connection[1];
      connected.add(from);
      connected.add(to);

      if (!uf.merge(from, to)) {
        extraConnection++;
      }
    }
    System.out.println("Parent analysis..");
    for (int i = 0; i < n; i++) {
      System.out.println(i + " Parent_Index= " + uf.parent[i]);
    }

    System.out.println("Parent analysis#2..");
    for (int i = 0; i < n; i++) {
      System.out.println(i + " Parent= " + uf.findParent(i));
    }

    return uf.componentCount() - 1;
  }
}

class UnionFind {

  public int[] parent;
  public int[] size;

  public UnionFind(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int componentCount() {
    Set<Integer> set = new HashSet();
    for (int i = 0; i < parent.length; i++) {
      set.add(findParent(i));
    }
    System.out.println("set=" + set);
    return set.size();
  }

  public int findParent(int val) {
    if (val == parent[val]) return parent[val];
    return parent[val] = findParent(parent[val]);
  }

  public boolean merge(int val1, int val2) {
    int parent1 = findParent(val1);
    int parent2 = findParent(val2);
    if (parent1 == parent2) return false;
    if (size[parent1] > size[parent2]) {
      parent[parent2] = parent1;
      size[parent1] += size[parent2];
    } else {
      parent[parent1] = parent2;
      size[parent2] += size[parent1];

    }
    return true;
  }
}

package utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class BfsNode {
  public int val;
  public LinkedHashSet<Integer> visited;

  public BfsNode(int _val, LinkedHashSet<Integer> _visited) {
    this.val = _val;
    visited = new LinkedHashSet<>();
    if (_visited != null)
      visited.addAll(_visited);
  }

  public int getVal() {
    return val;
  }

  public Set<Integer> getVisited() {
    return visited;
  }
}
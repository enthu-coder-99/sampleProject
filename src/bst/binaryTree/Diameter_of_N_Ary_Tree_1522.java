package bst.binaryTree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Diameter_of_N_Ary_Tree_1522 {

  int ans = 0;

  public int diameter(Node root) {
    calc(root);
    return ans;
  }

  public int calc(Node node) {
    if (node == null) return 0;
    List<Node> children = new ArrayList<>();//node.children;
    PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

    for (Node child : children) {
      int childDepth = calc(child);
      pq.add(childDepth);
    }
    int max1 = 0;
    int max2 = 0;
    if (pq.size() > 0)
      max1 = pq.poll();
    if (pq.size() > 0)
      max2 = pq.poll();
    ans = Math.max(ans, max1 + max2);
    return max1 + 1;


  }
}

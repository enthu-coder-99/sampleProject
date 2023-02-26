package algo.graph.misc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clone_Graph_133 {

  public Node cloneGraph(Node node) {
    Map<Node, Node> originalNodeToCloneMap = new HashMap<>();
    Deque<Node> origNodesQueue = new ArrayDeque<>();
    origNodesQueue.offer(node);
    //First create all Indivisual nodes and do not connect them.
    while (origNodesQueue.size() > 0) {
      Node origNode = origNodesQueue.poll();
      if (!originalNodeToCloneMap.containsKey(origNode)) {
        originalNodeToCloneMap.put(origNode, new Node(origNode.val));
        origNodesQueue.addAll(origNode.neighbors);
      }
    }

    // Now, Let us connect the new created Nodes.
    origNodesQueue = new ArrayDeque<>();
    origNodesQueue.offer(node);
    //First create all Indivisual nodes and do not connect them.
    while (origNodesQueue.size() > 0) {
      Node origNode = origNodesQueue.poll();
      Node newNode = originalNodeToCloneMap.get(origNode);
      if (origNode.neighbors != null && origNode.neighbors.size() > 0 && (newNode.neighbors == null || newNode.neighbors.size() == 0)) {
        for (Node origNeighbour : origNode.neighbors) {
          newNode.neighbors.add(originalNodeToCloneMap.get(origNeighbour));
          origNodesQueue.add(origNeighbour);
        }
      }
    }
    return originalNodeToCloneMap.get(node);
  }

}

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

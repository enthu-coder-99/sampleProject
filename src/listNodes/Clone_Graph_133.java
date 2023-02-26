package listNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clone_Graph_133 {

  public static void main(String[] args) {
    Node node1 = new Node(1, new ArrayList<>());
    Node node2 = new Node(2, new ArrayList());
    node1.neighbors.add(new Node(8));
    node1.neighbors.add(new Node(3));
    node2.neighbors.add(new Node(4));
    node2.neighbors.add(new Node(5));
    node2.neighbors.add(node1);
    Node node = cloneGraph(node1);
    System.err.println(node);
  }


  public static Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<>();
    Node clonedNode = cloneGraphList(node, map);
    return clonedNode;
  }

  static Node cloneGraphList(Node sourceNode, Map<Node, Node> map) {
    if (sourceNode == null)
      return null;
    System.err.println(sourceNode);
    if (map.containsKey(sourceNode)) return map.get(sourceNode);

    Node targetNewNode = new Node(sourceNode.val);
    for (Node neighbour : sourceNode.neighbors) {
      targetNewNode.neighbors.add(cloneGraphList(neighbour, map));
    }
    map.put(sourceNode, targetNewNode);
    return targetNewNode;
  }

  static class Node {
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

    @Override
    public String toString() {
      String str = "Node[" +
        "val=" + val + "], Neighbours={";
      for (Node n : neighbors) {
        str = str + n.val + ", ";
      }
      str = str + "}";
      return str;

    }
  }
}

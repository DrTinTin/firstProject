package com.undirectedgraph;

import java.util.*;

public class WeightedGraph {
  private class Node {
    private String label;
    private List<Edge> edges = new ArrayList<>();

    public Node(String label) {
      this.label = label;
    }

    public void addEdge(Node to, int weight) {
      edges.add(new Edge(this, to, weight));
    }
  }

  private class Edge {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

  public void addNode(String label) {
    var node = new Node(label);
    nodes.putIfAbsent(label, node);
    adjacencyList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(String from, String to, int weight) {
    var fromNode = nodes.get(from);
    if (fromNode == null) {
      throw new IllegalArgumentException();
    }
    var toNode = nodes.get(to);
    if (toNode == null) {
      throw new IllegalArgumentException();
    }
    adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
    adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
  }

  private class NodeEntry {
    private Node node;
    private int priority;

    public NodeEntry(Node node, int priority) {
      this.node = node;
      this.priority = priority;
    }
  }

  public int getShortestDistance(String from, String to) {
    var fromNode = nodes.get(from);
    Map<Node, Integer> distances = new HashMap<>();
    for (var node : nodes.values()) {
      distances.put(node, Integer.MAX_VALUE);
    }
    distances.replace(fromNode, 0);
    Set<Node> visited = new HashSet<>();

    PriorityQueue<NodeEntry> queue =
        new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    queue.add(new NodeEntry(fromNode, 0));

    while (!queue.isEmpty()) {
      var current = queue.poll().node;
      visited.add(current);
      for (var edge : adjacencyList.get(current)) {
        if (visited.contains(edge.to)) continue;
        var newDistance = distances.get(current) + edge.weight;
        if (newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }

    return distances.get(nodes.get(to));
  }

  public List<String> getShortestPath(String from, String to) {
    var result = new ArrayList<String>();
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    Map<Node, Integer> distances = new HashMap<>();
    Map<Node, Node> previous = new HashMap<>();
    for (var node : nodes.values()) {
      distances.put(node, Integer.MAX_VALUE);
    }
    distances.replace(fromNode, 0);
    Set<Node> visited = new HashSet<>();

    PriorityQueue<NodeEntry> queue =
        new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    queue.add(new NodeEntry(fromNode, 0));

    while (!queue.isEmpty()) {
      var current = queue.poll().node;
      visited.add(current);
      for (var edge : adjacencyList.get(current)) {
        if (visited.contains(edge.to)) continue;
        var newDistance = distances.get(current) + edge.weight;
        if (newDistance < distances.get(edge.to)) {
          distances.replace(edge.to, newDistance);
          previous.put(edge.to, current);
          queue.add(new NodeEntry(edge.to, newDistance));
        }
      }
    }

    Stack<Node> stack = new Stack<>();
    stack.push(toNode);
    var pre = previous.get(toNode);
    while (pre != null) {
      stack.push(pre);
      pre = previous.get(pre);
    }

    while (!stack.isEmpty()) {
      result.add(stack.pop().label);
    }

    return result;
  }

  private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
    visited.add(node);

    for (var edge : adjacencyList.get(node)) {
      if (edge.to == parent) continue;
      if (visited.contains(edge.to) || hasCycle(edge.to, node, visited)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCycle() {
    Set<Node> visited = new HashSet<>();

    for (var node : nodes.values()) {
      if (!visited.contains(node) && hasCycle(node, null, visited)) {
        return true;
      }
    }
    return false;
  }

  public WeightedGraph getMST() {
    var tree = new WeightedGraph();

    PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    var startNode = nodes.values().iterator().next();
    edges.addAll(adjacencyList.get(startNode));
    tree.addNode(startNode.label);
    while (tree.nodes.size() < nodes.size()) {
      var minEdge = edges.remove();
      var nextNode = minEdge.to;
      if (tree.nodes.containsKey(nextNode.label)) {
        continue;
      }
      tree.addNode(nextNode.label);
      tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);
      for (var edge : tree.adjacencyList.get(nextNode)) {
        if (!tree.nodes.containsKey(edge.to.label)) {
          edges.add(edge);
        }
      }
    }
    return tree;
  }
}

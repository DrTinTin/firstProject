package com.graph;

import java.util.*;

public class graphTest {}

class Graph {
  private class Node {
    private String label;

    public Node(String label) {
      this.label = label;
    }
  }

  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Node>> edges = new HashMap<>();

  public void addNode(String label) {
    var node = new Node(label);
    nodes.putIfAbsent(label, node);
    edges.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(String from, String to) {
    var fromNode = nodes.get(from);
    if (fromNode == null) {
      throw new IllegalArgumentException();
    }
    var toNode = nodes.get(to);
    if (toNode == null) {
      throw new IllegalArgumentException();
    }
    edges.get(fromNode).add(toNode);
  }

  public void removeNode(String label) {
    var node = nodes.get(label);
    if (node == null) return;
    for (var n : edges.keySet()) {
      edges.get(n).remove(node);
    }
    edges.remove(node);
    nodes.remove(node);
  }

  public void removeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode == null || toNode == null) return;

    edges.get(fromNode).remove(toNode);
  }

  public void DFS(String root) {
    var node = nodes.get(root);
    if (node == null) return;
    DFS(nodes.get(root), new HashSet<>());
  }

  private void DFS(Node root, Set<Node> visited) {
    System.out.println(root.label);
    visited.add(root);
    for (var node : edges.get(root)) {
      if (!visited.contains(node)) {
        DFS(node, visited);
      }
    }
  }

  public void BFS(String root) {
    var node = nodes.get(root);
    if (node == null) return;

    Set<Node> visited = new HashSet<>();

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      var current = queue.poll();
      if (visited.contains(current)) continue;
      System.out.println(current.label);
      visited.add(current);
      for (var neighbour : edges.get(current)) {
        if (!visited.contains(neighbour)) {
          queue.offer(neighbour);
        }
      }
    }
  }

  public List<String> topologicalSort() {
    Stack<Node> stack = new Stack<>();
    Set<Node> visited = new HashSet<>();

    for (var node : nodes.values()) {
      topologicalSort(node, visited, stack);
    }

    List<String> sorted = new ArrayList<>();
    while (!stack.isEmpty()) {
      sorted.add(stack.pop().label);
    }
    return sorted;
  }

  private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
    if (visited.contains(node)) {
      return;
    }
    visited.add(node);
    for (var neighbour : edges.get(node)) {
      topologicalSort(neighbour, visited, stack);
    }
    stack.push(node); // push this node into the stack after visiting all its neighbours
  }

  public boolean hasCycle() {
    Set<Node> all = new HashSet<>();
    all.addAll(nodes.values());

    Set<Node> visiting = new HashSet<>();
    Set<Node> visited = new HashSet<>();

    while (!all.isEmpty()) {
      var current = all.iterator().next();
      if (hasCycle(current, all, visiting, visited)) {
        return true;
      }
      ;
    }
    return false;
  }

  private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
    all.remove(node);
    visiting.add(node);
    for (var neighbour : edges.get(node)) {
      if (visited.contains(neighbour)) {
        continue;
      }
      if (visiting.contains(neighbour)) {
        return true;
      }
      if (hasCycle(neighbour, all, visiting, visited)) {
        return true;
      }
    }
    visiting.remove(node);
    visited.add(node);
    return false;
  }
}

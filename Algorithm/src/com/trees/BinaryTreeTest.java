package com.trees;

import java.util.ArrayList;

/**
 * Pre-order: root, left, right;
 *
 * <p>in-order: left, root, right;
 *
 * <p>post-order: left, right, root;
 */
public class BinaryTreeTest {
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insert(10);
    tree.insert(9);
    tree.insert(6);
    tree.insert(16);
    tree.insert(17);
    Tree tree2 = new Tree();
    tree2.insert(10);
    tree2.insert(9);
    tree2.insert(6);
    tree2.insert(16);
    tree2.insert(17);
    System.out.println(Tree.equals(tree.root, tree2.root));
    System.out.println(tree.isBinarySearchTree());
    System.out.println(tree.getNodesAtDistance(2));

  }
}

class Tree {
  private class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  public Node root;

  public void insert(int value) {
    if (root == null) {
      root = new Node(value);
      return;
    }
    var current = root;
    while (true) {
      if (value < current.value) {
        if (current.left == null) {
          current.left = new Node(value);
          break;
        }
        current = current.left;
      } else {
        if (current.right == null) {
          current.right = new Node(value);
          break;
        }
        current = current.right;
      }
    }
  }

  public boolean find(int value) {
    var current = root;
    while (current != null) {
      if (value < current.value) {
        current = current.left;
      } else if (value > current.value) {
        current = current.right;
      } else {
        return true;
      }
    }
    return false;
  }

  private void traversePreOrder(Node root) {
    if (root == null) return;
    System.out.println(root.value);
    traversePreOrder(root.left);
    traversePreOrder(root.right);
  }

  public void traversePreOrder() {
    traversePreOrder(root);
  }

  public int height() {
    return heights(this.root);
  }

  private int heights(Node node) {
    if (node == null) return Integer.MIN_VALUE;
    if (node.left == null && node.right == null) {
      return 0;
    }
    return 1 + Math.max(heights(node.left), heights(node.right));
  }

  public int minimum() {
    return min(this.root);
  }

  public int min(Node node) {
    if (node == null) return Integer.MAX_VALUE;
    if (node.left == null && node.right == null) {
      return node.value;
    }
    var left = min(node.left);
    var right = min(node.right);
    return Math.min(Math.min(left, right), node.value);
  }

  public static boolean equals(Node first, Node second) {
    if (first == null && second == null) {
      return true;
    }
    if (first != null && second != null) {
      return first.value == second.value
          && equals(first.left, second.left)
          && equals(first.right, second.right);
    }
    return false;
  }

  private boolean isBinarySearchTree(Node root, int min, int max) {
    if (root == null) return true;
    if (root.value < min || root.value > max) {
      return false;
    }
    return isBinarySearchTree(root.left, min, root.value - 1)
        && isBinarySearchTree(root.right, root.value + 1, max);
  }

  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  public ArrayList<Integer> getNodesAtDistance(int distance){
    var list = new ArrayList<Integer>();
    getNodesAtDistance(root, distance, list);
    return list;
  }
  private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
    if (root == null) return;
    if (distance == 0) {
      list.add(root.value);
      return;
    }
    getNodesAtDistance(root.left, distance-1, list);
    getNodesAtDistance(root.right, distance-1, list);
  }

}

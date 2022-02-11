package com.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieTest {
  public static void main(String[] args) {
    //
    Trie trie = new Trie();
    trie.insert("hello");
    var result = trie.contains("hello");
    System.out.println(result);
  }
}

class Trie {
  private class Node {
    private char value;
    private Node[] children = new Node[26];
    private boolean isEndofWord;

    public Node() {}

    public Node(char value) {
      this.value = value;
    }
  }

  private Node root = new Node();

  public void insert(String word) {
    var current = root;
    for (var ch : word.toCharArray()) {
      var index = ch - 'a';
      if (current.children[index] == null) {
        current.children[index] = new Node(ch);
      }
      current = current.children[index];
    }
    current.isEndofWord = true;
  }

  public boolean contains(String word) {
    var current = root;
    for (var ch : word.toCharArray()) {
      if (current.children[ch - 'a'] == null) {
        return false;
      }
      current = current.children[ch - 'a'];
    }
    return current.isEndofWord;
  }

  public void delete(String key) {
    root = delete(root, key, 0);
  }
  // 在删除之后返回的x

  /**
   * after the recursive calls for a node x,
   *
   * <p>we return null if the client is not the end of a word
   *
   * <p>and all of the links in a node are null;
   *
   * <p>otherwise we return x.
   *
   * @param x
   * @param key
   * @param d
   * @return the node that has been deprived of the chars from the key
   */
  private Node delete(Node x, String key, int d) {
    if (x == null) return null;
    if (d == key.length()) {
      x.isEndofWord = false;
    } else {
      char c = key.charAt(d);
      x.children[c - 'a'] = delete(x.children[c - 'a'], key, d + 1);
    }
    if (x.isEndofWord) return x;
    for (int i = 0; i < 26; i++) {
      if (x.children[i] != null) return x;
    }
    return null;
  }

  private Node findLastNodeOf(String prefix) {
    var current = root;
    for (var ch : prefix.toCharArray()) {
      var child = current.children[ch - 'a'];
      if (child == null) return null;
      current = child;
    }
    return current;
  }

  public List<String> findWords(String prefix) {
    List<String> words = new ArrayList<>();
    var lastNode = findLastNodeOf(prefix);
    findWords(lastNode, prefix, words);
    return words;
  }

  private void findWords(Node root, String prefix, List<String> words) {}

  // find the longest prefix of string s
  private int search(Node x, String s, int d, int length) {
    if (x == null) return length;
    if (x.isEndofWord) length = d;
    if (d == s.length()) return length;
    char c = s.charAt(d);
    return search(x.children[c - 'a'], s, d + 1, length);
  }

  public String longestPrefixOf(String s) {
    int length = search(root, s, 0, 0);
    return s.substring(0, length);
  }
}

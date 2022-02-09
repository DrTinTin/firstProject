package com.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListTest {
  public static void main(String[] args) {
    //

    var ls = new LkList();
    ls.addLast(1);
//    System.out.println(ls.size());
    ls.addLast(2);
    ls.addLast(3);
    ls.addLast(4);
    ls.reverse();
//    System.out.println(ls.size());
    System.out.println(ls.getKthFromTheEnd(2));
    // System.out.println(ls.indexOf(2));
  }
}

class LkList {
  private Node head;
  private Node tail;
  private int count;

  private class Node {
    int value;
    Node next;

    public Node() {}

    public Node(int value) {
      this.value = value;
    }
  }

  public void addLast(int item) {
    Node node = new Node(item);
    if (isEmpty()) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    count++;
  }

  public void addFirst(int item) {
    Node node = new Node(item);
    if (isEmpty()) {
      head = tail = node;
    } else {
      node.next = head;
      head = node;
    }
    count++;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int indexOf(int item) {
    int index = 0;
    var current = head;
    while (current != null) {
      if (current.value == item) {
        return index;
      } else {
        current = current.next;
        index++;
      }
    }
    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    count--;
    if (head == tail) {
      head = tail = null;
      return;
    }
    var second = head.next;
    head.next = null;
    head = second;
  }

  public void removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    count--;
    if (head == tail) {
      head = tail = null;
      return;
    }
    var previous = getPrevious(tail);
    previous.next = null;
    tail = previous;
  }

  public Node getPrevious(Node node) {
    var cur = head;
    while (cur.next != null) {
      if (cur.next == node) {
        return cur;
      }
      cur = cur.next;
    }
    return null;
  }

  public int size() {
    return count;
  }

  public int[] toArray() {
    int[] array = new int[count];
    var current = head;
    var index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }
    return array;
  }

  public void reverse() {
    var previous = head;
    var current = head.next;
    while (current != null) {
      var temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }

    tail = head;
    tail.next = null;
    head = previous;
  }

  public int getKthFromTheEnd(int k) {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    var a = head;
    var b = head;
    for (int i = 0; i < k - 1; i++) {
      b = b.next;
      if (b == null) {
        throw new IllegalArgumentException();
      }
    }
    while (b != tail) {
      a = a.next;
      b = b.next;
    }
    return a.value;
  }
}

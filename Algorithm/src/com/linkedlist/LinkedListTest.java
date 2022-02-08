package com.linkedlist;

import java.util.LinkedList;

public class LinkedListTest {
  public static void main(String[] args) {
    //
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    System.out.println(list.indexOf(10));

    var ls = new LkList();
    ls.addLast(1);
    ls.addLast(2);

  }
}

class LkList {
  private Node head;
  private Node tail;

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
  }

  public void addFirst(int item){
    Node node = new Node(item);
    if (isEmpty()){
      head = tail = node;
    } else{
      node.next = head;
      head = node;
    }
  }

  public boolean isEmpty(){
    return head == null;
  }

}

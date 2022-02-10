package com.queues;

import java.util.*;

public class QueueTest {
  public static void main(String[] args) {
    //
    Queue<String> queue1 = new LinkedList<>();
    var queue2 = new ArrayDeque<>();
    queue1.add("A");
    queue1.add("B");
    queue1.add("C");

    Collections.reverse((List<?>) queue1);
    PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2)->Integer.compare(o2, o1));
    que.add(3);
    que.add(7);
    que.add(2);
    que.add(1);
    que.add(5);
    while(!que.isEmpty()){
      System.out.println(que.poll());
    }

  }

  public static void reverse(Queue<Integer> queue) {
    Stack<Integer> stack = new Stack<>();
    while (!queue.isEmpty()) {
      stack.push(queue.poll());
    }
    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }
  }
}

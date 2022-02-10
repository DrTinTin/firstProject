package com.queues;

import java.util.Arrays;

public class PriorityQueueTest {
  private int[] items = new int[5];
  private int count;

  public void add(int item) {
    if (count == items.length) {
      throw new IllegalStateException();
    }
    // shifting items
    int i;
    for (i = count - 1; i >= 0; i--) {
      if (items[i] > item) {
        items[i + 1] = items[i];
      } else {
        break;
      }
    }
    items[i + 1] = item;
    count++;
  }

  @Override
  public String toString() {
    return "PriorityQueueTest{" + "items=" + Arrays.toString(items) + '}';
  }
}

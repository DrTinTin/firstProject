package com.heap;

/**
 * Transfer an array to heap in place: heapify
 */
public class HeapTest {
  public static void main(String[] args) {
    var heap = new Heap();
    heap.insert(10);
    heap.insert(20);
    heap.insert(40);
  }
}

class Heap {
  private int[] items = new int[10];
  private int size;

  public void insert(int value) {
    if (isFull()) {
      throw new IllegalStateException();
    }
    items[size++] = value;
    bubbleUp();
  }

  public boolean isFull() {
    return size == items.length;
  }

  private void bubbleUp() {
    var index = size - 1;
    var parentIndex = (index - 1) / 2;
    while (index > 0 && items[index] > items[parent(index)]) {
      swap(index, parentIndex);
      index = parent(index);
    }
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private void swap(int first, int second) {
    var temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }

  public void remove() {
    if (size == 0) {
      throw new IllegalStateException();
    }
    items[0] = items[--size];
    var index = 0;
    while (index <= size && !isValidParent(index)) {
      var largerChildIndex = largerChildIndex(index);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  private int largerChildIndex(int index) {
    if (!hasLeftChild(index)) {
      return index;
    }
    if (!hasRightChild(index)) {
      return leftChildIndex(index);
    }
    return (leftChild(index)) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index)) {
      return true;
    }
    var isValid = items[index] >= leftChild(index);
    if (!hasRightChild(index)) {
      isValid &= items[index] >= rightChild(index);
    }
    return isValid;
  }

  private int leftChild(int index) {
    return items[leftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[rightChildIndex(index)];
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }
}

package com.sort;

public class BubbleSort {
  public void sort(int[] array) {
    boolean isSorted;
    for (var i = 0; i < array.length; i++) {
      isSorted = true;
      for (var j = 1; j < array.length - i; j++) {
        if (array[j] < array[j - 1]) {
          var temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
          isSorted = false; // 存在前一个比后一个大，则为FALSE
        }
      }
      if (isSorted) return;
    }
  }
}

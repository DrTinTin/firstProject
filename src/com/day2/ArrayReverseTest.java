package com.day2;

import java.util.Arrays;

public class ArrayReverseTest {
  public static void main(String[] args) {
    //
    String[] arr = new String[] {"aa", "bb", "cc", "dd"};
    int i = 0, j = arr.length - 1;
    while (i < j) {
      String temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
    System.out.println(Arrays.toString(arr));
  }
}

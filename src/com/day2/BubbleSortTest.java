package com.day2;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSortTest {
  public static void main(String[] args) {
    //
    int[] arr = new int[]{-1, -23, 23, 43, 68, 109, 2, 31};
    // Bubble sort
    for (int i = 0; i < arr.length - 1; i++){
      for (int j = 0; j < arr.length - 1 - i; j++){
        if (arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));

  }
}

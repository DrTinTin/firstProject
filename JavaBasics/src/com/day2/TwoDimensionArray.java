package com.day2;

public class TwoDimensionArray {
  public static void main(String[] args) {
    //
    int[][] arr = new int[][] {{1, 2}, {3, 4}, {5, 6}};
    String[][] arr2 = new String[3][2];
    String[][] arr3 = new String[3][];
    System.out.println(arr3[0]);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.println(arr[i][j]);
      }
    }

    int[][] num = new int[4][3];
    System.out.println(num[0]);
    System.out.println(num[0][0]);
  }
}

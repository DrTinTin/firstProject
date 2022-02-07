package com.day2;

import java.util.Arrays;

public class ArrayTest {
  public static void main(String[] args) {
    //
    int[] arr = new int[12]; // dynamic initialization;
    arr = new int[] {1, 2, 3}; // static initialization;
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(Arrays.toString(arr));
    System.out.println(arr.length);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    // initial value of an array
    int[] num = new int[4];
    System.out.println(Arrays.toString(num));
    String[] str = new String[4];
    System.out.println(Arrays.toString(str));
    char[] chars = new char[4];
    System.out.println(Arrays.toString(chars));
    boolean[] arrBoolean = new boolean[4];
    System.out.println(Arrays.toString(arrBoolean));
    Boolean[] arrBoolean1 = new Boolean[4];
    System.out.println(Arrays.toString(arrBoolean1));
  }
}

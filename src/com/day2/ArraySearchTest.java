package com.day2;

import java.util.Arrays;

public class ArraySearchTest {
  public static void main(String[] args) {
    //
    String[] arr = new String[]{"A", "B", "C"};
    String dest = "A";
    for (int i = 0; i < arr.length; i++){
      if(dest.equals(arr[i])){
        System.out.println("Found!");
        break;
      }
    }

    //Binary search
    int[] arr2 = new int[]{1,2,3,6,12,34,56,32,78,43,56,7,8,98};
    Arrays.sort(arr2);
    int dest1 = 34;
    int left = 0, right = arr2.length-1;
    while (left <= right){
      int mid = left + (right - left)/2;
      if (arr2[mid] == dest1){
        System.out.println("Found! The position is: " + mid);
        break;
      }else if(arr2[mid] > dest1){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }
  }
}

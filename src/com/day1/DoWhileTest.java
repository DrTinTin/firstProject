package com.day1;

public class DoWhileTest {
  public static void main(String[] args) {
    //
    int num = 1;
    do {
      if (num % 2 == 0) {
        System.out.println(num);
      }
      num++;
    } while (num <= 100);
  }
}

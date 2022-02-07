package com.day1;

public class PrimeNumberTest {
  public static void main(String[] args) {
    //
    long start = System.currentTimeMillis();
    boolean isFlag = true;
    for (int i = 2; i <= 1000; i++) {
      for (int j = 2; j < Math.sqrt(i); j++) {
        if (i % j == 0) {
          isFlag = false;
          break;
        }
      }
      if (isFlag) {
        System.out.println(i);
      }
      isFlag = true;
    }
    long end = System.currentTimeMillis();
    long timeLast = end - start;
    System.out.println("Time used: " + timeLast);
  }
}

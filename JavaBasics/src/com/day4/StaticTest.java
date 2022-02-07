package com.day4;

public class StaticTest {
  public static void main(String[] args) {
    //
    String nation = Chinese.nationality;
    System.out.println(nation);
    Chinese ch1 = new Chinese(); // 这里ch1是没有nationality这个属性的
    Chinese.show();
  }
}

class Chinese {
  public static final String nationality = "China";

  public static void show() {
    System.out.println("I am a Chinese.");
  }
}

package com.day4;

public class EqualsTest {
  public static void main(String[] args) {
    // equals 只适用于引用数据
    var p1 = new Person();
    var p2 = new Person();
    p1.setId(123);
    p1.setAge(12);
    p1.setName("Tom");
    p2.setId(123);
    System.out.println(p1.equals(p2));
    System.out.println(p1);
  }
}

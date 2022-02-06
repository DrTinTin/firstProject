package com.day4;

public class ObjectTest {
  public static void main(String[] args) {
    //
    Person p1 = new Person(12, "Tom", 900);
    System.out.println(p1.getClass().getSuperclass());
    String str1 = "Hei";
    String str2 = "Hei";
    System.out.println(str1 == str2);
  }
}

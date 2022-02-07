package com.day6.string;

public class StringTest {
  public static void main(String[] args) {
    //
    String str1 = "abc";
    var str3 = new String("defg");
    var str4 = new String("defg");
    System.out.println(str3 == str4); // false
    var str2 = str1.replace('a', 'd');
    System.out.println(str2);
  }
}

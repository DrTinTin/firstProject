package com.day6.string;

import org.junit.jupiter.api.Test;

public class StringMethodTest {
  public static void main(String[] args) {
    //
    String s1 = "abcde";
    System.out.println(s1.length());
    System.out.println(s1.charAt(0));
    System.out.println(s1.isEmpty());
    System.out.println(s1.trim());
    System.out.println(s1.substring(0, 3));
    System.out.println(s1.substring(1));
  }

  @Test
  public void test(){
    String str1 = "abdcde";
    String str2 = "Abdcde";
    System.out.println(str1.equalsIgnoreCase(str2));
    System.out.println(str1.concat(str2));
    System.out.println(str1.compareTo(str2));
    System.out.println((int)'a');
  }

  @Test
  public void test2(){
    String str1 = "hello";
    System.out.println(str1.endsWith("o"));
    System.out.println(str1.startsWith("h"));

    String str2 = "lo";
    System.out.println(str1.contains(str2));
    System.out.println(str1.indexOf("ll"));
    System.out.println(str1.toCharArray());
  }
}

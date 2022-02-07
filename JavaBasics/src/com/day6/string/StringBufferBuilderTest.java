package com.day6.string;

/**
 * StringBuffer: 线程安全但是效率低下
 *
 *
 * StringBuilder：线程不安全但是效率高，使用更多
 */
public class StringBufferBuilderTest {
  public static void main(String[] args) {
    //
    StringBuilder sb = new StringBuilder();
    sb.append(1234);
    sb.append('a');
    sb.deleteCharAt(0);
    //sb.reverse();
    sb.replace(1,2,"a");
    sb.setCharAt(0, 'b');
    sb.insert(3,"abdcd");
    System.out.println(sb);
  }
}

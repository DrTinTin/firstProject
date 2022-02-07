package com.day4;

import org.junit.jupiter.api.Test;

public class WrapperTest {
  @Test
  public void test1() {
    int num1 = 10;
    Integer in1 = 10;
    System.out.println(in1);

    Integer in2 = 123;

    Boolean b1 = true;
    Boolean b2 = false;
    System.out.println(b2);
  }

  @Test
  public void test2() {
    Integer in1 = new Integer(12);
    int i1 = in1.intValue();
    System.out.println(i1);
  }

  @Test
  public void test3() {
    // autoboxing
    int num = 10;
    Integer in1 = num;
    System.out.println(in1);

    // 自动拆箱
    int num2 = in1;
  }

  // 基本数据类型、包装类--》String
  @Test
  public void test4() {
    int num1 = 10;
    String str1 = num1 + "";
    String str2 = String.valueOf(num1);
  }

  @Test
  public void test5(){
    String str1 = "123";
    int num = Integer.valueOf(str1);
    int num1 = Integer.parseInt(str1);
    System.out.println(num);
  }
}

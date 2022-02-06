package com.day3;

public class VarArgsTest {
  public static void main(String[] args) {
    //
    show("hello", "World");
  }

  public static void show(String... strs) {
    for (int i = 0; i < strs.length; i++) {
      System.out.println(strs[i]);
    }
  }

//  public void show(String[] strs){
//
//  }
  /**
   * 可变形参只能放在参数列表的末尾！
   * 最多只能声明一个可变形参！
   */
  public static void show(int i, String ... strs){

  }


}

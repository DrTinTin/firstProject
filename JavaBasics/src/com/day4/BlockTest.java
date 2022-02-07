package com.day4;

public class BlockTest {
  public static void main(String[] args) {
    //
    String des = Personal.desc;
    Personal p1 = new Personal();
  }
}

/**
 * 代码块的作用：用来初始化类或者对象；
 *
 * <p>只能用static修饰：静态代码块和非静态代码块 静态代码块随着类的加载而执行，且执行一次！
 *
 * <p>动态代码块随着对象的创建而执行，每创建一个对象就执行一个非静态代码块，可以对对象属性进行初始化
 */
class Personal {

  public static String desc = "I am good!";

  public Personal() {}

  // 代码块
  static {
    System.out.println("This is a static block.");
  }

  {
    System.out.println("This is a dynamic block.");
  }
}

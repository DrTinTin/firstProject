package com.day4;

/**
 * 类A在类B之中，则A为内部类
 *
 * <p>内部类：静态和非静态；成员和局部
 *
 * <p>内部类可以被final和abstract修饰
 *
 * <p>内部类可以被四种权限修饰
 */
public class InnerClassTest {
  public static void main(String[] args) {
    Door.C c = new Door.C(); // static inner class
    Door.B b = new Door().new B();// non-static inner class instantiation

  }
}

class Door {
  class B {
    public void sing() {
      Door.this.eat();
    }
  } // 成员内部类

  static class C {}

  public void eat() {}

  public void method() {
    class A {} // 局部内部类
    System.out.println();
  }
}

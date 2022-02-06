package com.day4;

public class SingletonTest {
  public static void main(String[] args) {
    //
    Bank b1 = Bank.getInstance(); // 饿汉式
    Order r1 = Order.getInstance();
    Order r2 = Order.getInstance();
    System.out.println(r1 == r2);
  }
}

class Bank {
  // 私有化构造器，防止从外部创建实例
  private Bank() {}

  private static Bank instance = new Bank();

  public static Bank getInstance() {
    return instance; // 静态方法中，返回对象也是静态的；
  }
}

class Order {
  private Order() {}

  private static Order instance = null;

  public static Order getInstance() {
    if (instance == null) {
      instance = new Order();
    }

    return instance;
  }
}

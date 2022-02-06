package com.day4;

/**
 * 可以定义抽象方法和全局常量
 *
 * <p>接口中不能定义构造器，接口不可实例化；
 *
 * <p>接口通过implements来使用；如果重写了所有抽象方法，则可以实例化，否则为抽象类；
 *
 * <p>一个类可以实现多个接口
 *
 * <p>接口之间可以多继承
 *
 *
 */
public class InterfaceTest {
  public static void main(String[] args) {
    System.out.println(Flyable.MAX_SPEED);
    // 接口的匿名实现类
    Flyable fly =
        new Flyable() {
          @Override
          public void fly() {
            System.out.println("This is an implementation of the interface!");
          }
        };
    fly.fly();
  }
}

interface Flyable {
  public static final int MAX_SPEED = 100;

  public abstract void fly(); // public abstract可以省略不写
}

class Plane implements Flyable {

  @Override
  public void fly() {
    System.out.println("A plane can fly!");
  }
}

interface AA {
  void method1();
}

interface BB {
  void method2();
}

interface CC extends AA, BB {
  void method3();
}

class DD implements CC {

  @Override
  public void method1() {}

  @Override
  public void method2() {}

  @Override
  public void method3() {}
}

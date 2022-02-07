package com.day4;

/**
 * abstract keyword:
 *
 * <p>可以用来修饰公共类和方法
 *
 * <p>修饰类，则不能实例化，只能做父类，但是构造器是可以被继承的
 *
 * <p>抽象方法只有声明，没有方法体；抽象方法一定在抽象类中
 *
 * <p>子类重写了抽象类之后，才可以实例化，否则仍为抽象类
 *
 * <p>匿名子类的调用方法
 */
public class AbstractTest {
  public static void main(String[] args) {
    // 创建一个匿名子类
    var creature =
        new Animal() {
          @Override
          public void talk() {
            System.out.println("This dog is barking!");
          }
        };
    creature.talk();
    creature.age = 12;
  }
}

abstract class Animal {
  String name;
  int age;

  public Animal() {}

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void eat() {
    System.out.println("Eat!");
  }

  public abstract void talk();
}

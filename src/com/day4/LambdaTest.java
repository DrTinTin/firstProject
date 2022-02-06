package com.day4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda写法：
 *
 * <p>左边：接口中抽象方法的形参列表；
 *
 * <p>右边： Lambda体（重写的抽象方法）
 *
 * <p>Lambda表达式本质上是接口的实例；
 */
public class LambdaTest {
  @Test
  public void test1() {
    // 无参数，无返回值
    Runnable r1 =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("Hello. world!");
          }
        };
    r1.run();
    Runnable r2 = () -> System.out.println("Hello, world!");
    r2.run();
  }

  @Test
  public void test2() {
    Comparator<Integer> com1 =
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
          }
        };
    // Lambda
    Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

    // 方法引用
    Comparator<Integer> com3 = Integer::compare;
  }

  @Test
  public void test3() {
    // 一个参数但是没有返回值
    Consumer<String> con =
        new Consumer<String>() {
          @Override
          public void accept(String s) {
            System.out.println(s);
          }
        };
    con.accept("Hello, world!");

    Consumer<String> con1 = s -> System.out.println(s);
    con1.accept("Goodbye!");
  }

  @Test
  public void test5() {
    Comparator<Integer> com =
        (o1, o2) -> {
          System.out.println("1");
          System.out.println("2");
          return o1.compareTo(o2);
        };
  }
}

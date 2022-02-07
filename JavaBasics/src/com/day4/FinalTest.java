package com.day4;

/**
 * 1. final修饰类，则该类不能有子类, 比如String， system， StringBUffer
 *
 * <p>2. final修饰方法，则此方法不能被重写，比如object类中的getClass（）；
 *
 * <p>3. final修饰属性，则属性赋值不可改变；可以在代码块，构造器中赋值；如果有
 *
 * <p>多个构造器，则每个都需要赋值
 *
 * <p>4. final 修饰局部变量，则此形参为常量，不可在方法体中改变
 *
 * <p>5. static final 修饰属性则为全局常量；修饰方法比较少
 */
public class FinalTest {
  public static void main(String[] args) {
    //

  }
}

final class FinalA {}

class B {
  public final String name = "Tom";
  public final String country;

  {
    country = "China";
  }

  public void show(final int num) {
    System.out.println(num);
  }
}

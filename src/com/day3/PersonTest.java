package com.day3;

/** Field Method */
public class PersonTest {
  public static void main(String[] args) {
    var p1 = new Person("Tom", 12, true);
    p1.talk("English");
    int[] a = new int[]{1,2,3};
    int[] b = a;
    a[0] = 2;
    System.out.println("a is: "+ a[0]);
    System.out.println("b is: "+ b[0]);

  }
}

class Person {
  String name;
  int age;
  boolean isMale;

  public Person(String name, int age, boolean isMale) {
    this.name = name;
    this.age = age;
    this.isMale = isMale;
  }

  public void talk(String language) {
    System.out.println("This person can speak: " + language);
  }
}

package com.day4;

public class Student extends Person {
  private String major;

  public Student(int age, String name, int id, String major) {
    super(age, name, id);
    this.major = major;
  }
  // 返回值类型可以是父类中方法返回值类型的子类；只有非static方法才能重写！
  @Override
  public void show() {
    System.out.println("I am a good student.");
  }
}

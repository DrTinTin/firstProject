package com.day4;

public class Person {
  private int age;
  private String name;
  private int id;

  public Person(int age, String name, int id) {
    this.age = age;
    this.name = name;
    this.id = id;
  }

  public Person() {}

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void show() {
    System.out.println("I am a good man.");
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Person)) return false;
    Person p = (Person) obj;
    return this.id == p.id;
  }

  @Override
  public String toString() {
    return "This person is " + this.age + " years old. His/Her name is " + this.name;
  }
}

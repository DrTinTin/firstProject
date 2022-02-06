package com.day4;

/** 多态性：父类的引用指向子类的对象； 调用了父类的方法，执行的是子类的程序 多态性不适用于属性 */
public class PolymorphismTest {
  public static void main(String[] args) {
    //
    Person p1 = new Student(12, "Tom", 23, "Math");
    p1.show(); // It will call the method of Student class; 只能调用父类中定义的方法
    if (p1 instanceof Person) {
      System.out.println("p1 is an instance of Person!");
    }
    Student st1 = (Student) p1; // 向下强制转型，转之前用instanceof检查

  }
}

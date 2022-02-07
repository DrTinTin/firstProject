package com.day5;

import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 异常处理:抓抛模型 过程1：抛：程序在正常执行过程中，一旦出现异常，就会在异常处生成一个对象，并将此
 *
 * <p>异常对象抛出，后面的代码不再执行；
 *
 * <p>过程2：抓：（1）try-catch-finally (2)throws
 *
 * <p>try{ 可能出现异常的代码 }
 *
 * <p>catch(异常类型 变量名){ 处理异常的方式 }
 *
 * <p>finally{ 一定会执行的代码 }
 *
 * <p>编译时异常一定要处理，可以用try-catch, 也可以用throws；运行时异常一般不写try-catch
 *
 * <p>throws + 异常类型写在方法声明处
 *
 * <p>子类重写方法抛出的异常类型不大于父类的异常；父类没用throws则子类也不能用
 *
 *
 */
public class ExceptionTest {
  @Test
  public void test1() {
    String str = "abc";
    try {
      int num = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      System.out.println("The input string is not a number!");
    }
  }

  public void method() throws FileNotFoundException {
    File file = new File("data.txt");
    FileInputStream fis = new FileInputStream(file);
  }
}

class Teacher{
  int id;
  public void register(int id) throws Exception {
    if (id > 0){
      this.id = id;
    }else{
      throw new Exception("Illegal input!"); // 创建了一个异常对象
    }
  }
}

class MyException extends RuntimeException{
  public MyException(){}
  public MyException(String str){
    super(str);
  }

}
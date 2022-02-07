package com.day5;

/**
 * 多线程创建：
 *
 * <p>方法1.继承Thread类，重写run（），创建实例，调用start（）:不能直接用run()
 *
 *
 */
public class ThreadTest {
  public static void main(String[] args) {
    MyThread mt = new MyThread();
    MyThread mt2 = new MyThread();
    mt.start();
    mt2.start();
  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(i);
    }
  }
}

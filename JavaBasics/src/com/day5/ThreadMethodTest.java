package com.day5;

/**
 * run(), start()
 *
 * <p>currentthread()
 *
 * <p>getName()
 *
 * <p>setName()
 *
 * <p>yield() 释放当前的线程
 *
 * <p>在线程a中执行b.join():开始执行线程b直到b执行完毕
 *
 * sleep（）
 *
 * 线程优先级：1-10；
 */
public class ThreadMethodTest {
  public static void main(String[] args) {
    //
    Thread.currentThread().setName("Main Thread");
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + ":" + i);
    }
    SonThread s1 = new SonThread();
    s1.setName("Thread 1");

    s1.start();
  }
}

class SonThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {

      System.out.println(Thread.currentThread().getName() +":" + getPriority()+":" + i);
    }

  }
}

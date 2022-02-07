package com.day5;

/**
 * 线程安全问题主要由线程的阻塞导致
 *
 * <p>解决方法：当线程a在操作一个对象时，其他线程不能参与进来，直到线程a完成了操作之后，
 *
 * <p>该对象才被释放。
 *
 * <p>两种方法：
 *
 * <p>方法1： 同步代码块
 *
 * <p>synchronized（同步监视器）{ 需要被同步的代码：操作共享数据的代码 }
 *
 * <p>同步监视器： 任何类的对象都可以充当锁；多个线程必须要公用同一把锁；
 *
 * <p>方式2： 同步方法: static synchronized的锁是***.class
 */
public class ThreadSafetyTest {
  public static void main(String[] args) {
    var w = new Windows();
    var t1 = new Thread(w);
    var t2 = new Thread(w);
    var t3 = new Thread(w);
    t1.start();
    t2.start();
    t3.start();
  }
}

class Windows implements Runnable {
  private static int ticket = 100;  // 如果创建了多个windows类, 则共享数据要static
  private static Object obj = new Object();

  @Override
  public void run() {
    while (true) {
      synchronized (obj) {
      // synchronized(Windows.class){
        if (ticket > 0) {
          System.out.println("Available tickets: " + ticket);
          ticket--;
        } else {
          break;
        }
      }
    }
  }
}

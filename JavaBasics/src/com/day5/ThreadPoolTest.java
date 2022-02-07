package com.day5;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/** 创建线程的方式4： 使用线程池 */
public class ThreadPoolTest {
  public static void main(String[] args) {
    //
    var service = Executors.newFixedThreadPool(10);
    var service1 = (ThreadPoolExecutor) service;
    service1.setCorePoolSize(10);

    service.execute(
        new Runnable() {
          @Override
          public void run() {
            for (int i = 0; i < 10; i++) {
              System.out.println(i);
            }
          }
        });
    service.shutdown();
  }
}

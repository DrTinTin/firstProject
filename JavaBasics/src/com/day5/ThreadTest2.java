package com.day5;

/**
 * 创建多线程：实现runnable接口
 */
public class ThreadTest2 {
  public static void main(String[] args) {
    //
    Thread th1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                System.out.println(i);
            }
        }
    });
    th1.start();
  }
}


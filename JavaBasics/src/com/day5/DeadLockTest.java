package com.day5;

public class DeadLockTest {
  public static void main(String[] args) {
    //
  StringBuffer b1 = new StringBuffer();
  StringBuffer b2 = new StringBuffer();
    new Thread() {
      @Override
      public void run() {
        synchronized (b1) {
          b1.append('a');
          b2.append('e');
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b2) {
            b1.append("1");
            b2.append("2");
            System.out.println(b1);
            System.out.println(b2);
          }
        }
      }
    }.start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (b2) {
                b1.append('4');
                b2.append('5');
                synchronized (b1) {
                    b1.append("j");
                    b2.append("k");
                    System.out.println(b1);
                    System.out.println(b2);
                }
            }
        }
    }).start();




  }
}

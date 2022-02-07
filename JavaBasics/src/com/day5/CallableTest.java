package com.day5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 创建线程的方式3： 实现Callable接口； */
public class CallableTest {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    NumThread numThread = new NumThread();
    var futureTask = new FutureTask<>(numThread);
    new Thread(futureTask).start();
    Object sum = futureTask.get();
    System.out.println(sum);

    var futureTask2 = new FutureTask<>(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        return 0;
      }
    });
  }
}

class NumThread implements Callable {

  @Override
  public Object call() throws Exception {
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
      System.out.println(i);
      sum += i;
    }
    return sum;
  }
}

package com.day4;

/**
 * 接口中的static method只能通过接口本身调用
 *
 * <p>接口中的default method可以通过实现类的实例来调用
 *
 * <p>父类中的同名方法优先于接口中的方法
 */
public class ProxyTest {
  public static void main(String[] args) {
    Server server = new Server();
    server.show();
    var proxy = new ProxyServer(server);
    proxy.browse();
    NetWork.status();
  }
}

interface NetWork {
  void browse();

  public static void status() {
    System.out.println("The status is good.");
  }

  default void show() {
    System.out.println("This is a default method!");
  }
}

class Server implements NetWork {

  @Override
  public void browse() {
    System.out.println("True network.");
  }
}

class ProxyServer implements NetWork {
  private NetWork work;

  public ProxyServer(NetWork work) {
    this.work = work;
  }

  private void check() {
    System.out.println("Check the work!");
  }

  @Override
  public void browse() {
    check();
    work.browse();
  }
}

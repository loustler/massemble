package io.loustler.massemble.designpattern.singleton;

public class JSingletonDemo {
  public static void main(String[] args) {
    final JSingleton jSingleton1 = JSingleton.getInstance("hello");
    final JSingleton jSingleton2 = JSingleton.getInstance("world!");

    assert jSingleton1.getValue().equals("hello");
    assert jSingleton2.getValue().equals("hello");

    final Thread thread1 = new Thread(
      new Runnable() {

        @Override
        public void run() {
          JThreadSafeSingleton singleton = JThreadSafeSingleton.getInstance("Hello");

          System.out.println(singleton.getValue());
        }
      }
    );

    final Thread thread2 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          JThreadSafeSingleton singleton = JThreadSafeSingleton.getInstance("World");

          System.out.println(singleton.getValue());
        }
      }
    );

    thread1.start();
    thread2.start();
  }

}

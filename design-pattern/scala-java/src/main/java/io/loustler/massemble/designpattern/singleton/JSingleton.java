package io.loustler.massemble.designpattern.singleton;

public class JSingleton {
  private static JSingleton instance;

  private final  String     value;

  private JSingleton(String value) {
    this.value = value;
  }

  public static JSingleton getInstance(String value) {
    if (instance == null) instance = new JSingleton(value);

    return instance;
  }

  public String getValue() {
    return this.value;
  }
}

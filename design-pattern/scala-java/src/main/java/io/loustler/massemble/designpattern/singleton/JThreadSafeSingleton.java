package io.loustler.massemble.designpattern.singleton;

public class JThreadSafeSingleton {

  private static volatile JThreadSafeSingleton instance;

  private final String value;

  private JThreadSafeSingleton(String value) {
    this.value = value;
  }

  /**
   * Double-checked Locking(DCL).
   *
   * @param value value
   * @return singleton instance
   */
  public static JThreadSafeSingleton getInstance(String value) {
    JThreadSafeSingleton result = instance;

    if (instance != null) return instance;

    synchronized (JThreadSafeSingleton.class) {
      if (instance == null) instance = new JThreadSafeSingleton(value);

      return instance;
    }
  }

  public String getValue() {
    return this.value;
  }
}

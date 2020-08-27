package io.loustler.massemble.designpattern.example.logger;

public final class ConsoleJLogger implements JLogger {
  @Override
  public void debug(String str) {
    System.out.printf("[DEBUG] %s", str);
  }

  @Override
  public void info(String str) {
    System.out.printf("[INFO] %s \n", str);
  }

  @Override
  public void error(String str, Throwable throwable) {
    System.out.printf("[ERROR] %s \n", str);
  }

  @Override
  public void warn(String str) {
    System.out.printf("[WARN] %s \n", str);
  }
}

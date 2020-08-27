package io.loustler.massemble.designpattern.example.logger;

public final class NoJLogger implements JLogger {
  @Override
  public void debug(String str) {}

  @Override
  public void info(String str) {}

  @Override
  public void error(String str, Throwable throwable) {}

  @Override
  public void warn(String str) {}
}

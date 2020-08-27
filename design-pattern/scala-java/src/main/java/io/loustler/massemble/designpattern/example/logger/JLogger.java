package io.loustler.massemble.designpattern.example.logger;

public interface JLogger {
  void info(String str);

  void debug(String str);

  void warn(String str);

  void error(String str, Throwable throwable);
}

package io.loustler.massemble.designpattern.factory.abstract_factory;

import io.loustler.massemble.designpattern.example.command.JCommand;
import io.loustler.massemble.designpattern.example.logger.JLogger;

public final class JAbstractFactoryApp {
  private final JLogger jLogger;

  private final JCommand jCommand;

  public JAbstractFactoryApp(JAbstractFactory factory) {
    this.jLogger = factory.logger();
    this.jCommand = factory.commander();
  }

  public void run() {
    jLogger.info("Run this app");

    jCommand.exec();
  }
}

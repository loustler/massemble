package io.loustler.massemble.designpattern.factory.abstract_factory;

import io.loustler.massemble.designpattern.example.command.JCommand;
import io.loustler.massemble.designpattern.example.command.WindowsJCommand;
import io.loustler.massemble.designpattern.example.logger.NoJLogger;
import io.loustler.massemble.designpattern.example.logger.JLogger;

public final class WindowsJAbstractFactory implements JAbstractFactory {
  @Override
  public JLogger logger() {
    return new NoJLogger();
  }

  @Override
  public JCommand commander() {
    return new WindowsJCommand();
  }
}

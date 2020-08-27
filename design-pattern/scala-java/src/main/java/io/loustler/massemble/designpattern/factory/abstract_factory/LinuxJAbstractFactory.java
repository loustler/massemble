package io.loustler.massemble.designpattern.factory.abstract_factory;

import io.loustler.massemble.designpattern.example.command.JCommand;
import io.loustler.massemble.designpattern.example.command.LinuxJCommand;
import io.loustler.massemble.designpattern.example.logger.ConsoleJLogger;
import io.loustler.massemble.designpattern.example.logger.JLogger;

public final class LinuxJAbstractFactory implements JAbstractFactory {
  @Override
  public JLogger logger() {
    return new ConsoleJLogger();
  }

  @Override
  public JCommand commander() {
    return new LinuxJCommand();
  }
}

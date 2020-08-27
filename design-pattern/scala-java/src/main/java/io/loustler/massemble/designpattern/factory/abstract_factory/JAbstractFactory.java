package io.loustler.massemble.designpattern.factory.abstract_factory;

import io.loustler.massemble.designpattern.example.logger.JLogger;
import io.loustler.massemble.designpattern.example.command.JCommand;

interface JAbstractFactory {
  JLogger logger();

  JCommand commander();
}

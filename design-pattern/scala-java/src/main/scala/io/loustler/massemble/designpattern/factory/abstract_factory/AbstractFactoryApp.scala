package io.loustler.massemble.designpattern.factory.abstract_factory

import io.loustler.massemble.designpattern.example.{ Commander, Logger }

final class AbstractFactoryApp private (logger: Logger, commander: Commander) {

  def run(): Unit = {
    logger.info("Run this App")

    commander.exec()
  }
}

object AbstractFactoryApp {

  def apply(factory: AbstractFactory): AbstractFactoryApp =
    new AbstractFactoryApp(
      factory.logger,
      factory.commander
    )
}

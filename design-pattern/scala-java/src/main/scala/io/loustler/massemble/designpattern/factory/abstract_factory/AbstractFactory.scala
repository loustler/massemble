package io.loustler.massemble.designpattern.factory.abstract_factory

import io.loustler.massemble.designpattern.example.{ Commander, Logger }

sealed trait AbstractFactory {
  val logger: Logger

  val commander: Commander
}

object AbstractFactory {

  final object Linux extends AbstractFactory {
    override val logger: Logger = Logger.Console

    override val commander: Commander = Commander.Linux
  }

  final object Windows extends AbstractFactory {
    override val logger: Logger = Logger.Nope

    override val commander: Commander = Commander.Windows
  }
}

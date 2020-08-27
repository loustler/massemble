package io.loustler.massemble.designpattern.factory.abstract_factory

object AbstractFactoryDemo {

  def main(args: Array[String]): Unit = {
    val factory: AbstractFactory = System.getProperty("os.name").toLowerCase() match {
      case "window" => AbstractFactory.Windows

      case _ => AbstractFactory.Linux
    }

    val app: AbstractFactoryApp = AbstractFactoryApp(factory)

    app.run()
  }
}

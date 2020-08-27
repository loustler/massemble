package io.loustler.massemble.designpattern.example

sealed trait Commander {
  def exec(): Unit
}
object Commander {
  final object Linux extends Commander {
    override def exec(): Unit = println("Linux Command")
  }

  final object Windows extends Commander {
    override def exec(): Unit = println("Windows Command")
  }
}

package io.loustler.massemble.designpattern.example

sealed trait Logger {
  def info(str: => String): Unit

  def debug(str: => String): Unit

  def warn(str: => String): Unit

  def error(str: => String): Unit
}

object Logger {

  final object Console extends Logger {
    override def info(str: => String): Unit = println(s"[INFO] $str")

    override def debug(str: => String): Unit = println(s"[DEBUG] $str")

    override def warn(str: => String): Unit = println(s"[WARN] $str")

    override def error(str: => String): Unit = println(s"[ERROR] $str")
  }

  final object Nope extends Logger {
    override def info(str: => String): Unit = ()

    override def debug(str: => String): Unit = ()

    override def warn(str: => String): Unit = ()

    override def error(str: => String): Unit = ()
  }
}

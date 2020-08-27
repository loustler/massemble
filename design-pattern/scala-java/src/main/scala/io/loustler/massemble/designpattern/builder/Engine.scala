package io.loustler.massemble.designpattern.builder

sealed trait Engine extends Product with Serializable

object Engine {
  case object V3 extends Engine
  case object V4 extends Engine
  case object V6 extends Engine
  case object V8 extends Engine
}

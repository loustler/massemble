package io.loustler.massemble.designpattern.builder

sealed trait Type extends Product with Serializable

object Type {
  case object SportsCar extends Type
  case object F1        extends Type
  case object SUV       extends Type
  case object Sedan     extends Type
}

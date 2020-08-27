package io.loustler.massemble.designpattern.builder

// ADT
trait Transmission extends Product with Serializable

object Transmission {
  case object Manual   extends Transmission
  case object Auto     extends Transmission
  case object SemiAuto extends Transmission
}

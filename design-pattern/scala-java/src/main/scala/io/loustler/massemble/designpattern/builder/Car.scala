package io.loustler.massemble.designpattern.builder

final case class Car private (
  `type`: Type,
  seats: Int,
  engine: Engine,
  transmission: Transmission,
  navigator: GPSNavigator
) {
  def drive(): Unit = println("drive")
}

object Car {

  def apply(
    `type`: Type = Type.Sedan,
    seats: Int = 4,
    engine: Engine = Engine.V4,
    transmission: Transmission = Transmission.Auto,
    navigator: GPSNavigator = GPSNavigator.Hyundai
  ): Car =
    new Car(
      `type` = `type`,
      seats = seats,
      engine = engine,
      transmission = transmission,
      navigator = navigator
    )
}

package io.loustler.massemble.designpattern.builder

object BuilderDemo {

  def main(args: Array[String]): Unit = {
    val car: Car = Car(engine = Engine.V6, navigator = GPSNavigator.TMap)

    assert(car.`type` == Type.Sedan)
    assert(car.engine == Engine.V6)
    assert(car.seats == 4)
    assert(car.transmission == Transmission.Auto)
    assert(car.navigator == GPSNavigator.TMap)

    car.drive()
  }
}

package io.loustler.massemble.designpattern.example.car;

public class BuilderDemo {
  public static void main(String[] args) {
    final JCar myCar = JCar.builder()
      .withType(JType.SEDAN)
      .withSeats(4)
      .withEngine(JEngine.V6)
      .withTransmission(JTransmission.AUTO)
      .withGpsNavigator(JGPSNavigator.T_MAP)
      .build();

    myCar.drive();
  }
}

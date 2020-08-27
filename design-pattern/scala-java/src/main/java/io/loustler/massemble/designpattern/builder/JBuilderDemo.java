package io.loustler.massemble.designpattern.builder;

public class JBuilderDemo {
  public static void main(String[] args) {
    final JCar myCar = JCar.builder()
      .withEngine(JEngine.V6)
      .withGpsNavigator(JGPSNavigator.T_MAP)
      .build();

    assert myCar.getType().equals(JType.SEDAN);
    assert myCar.getSeats() == 4;
    assert myCar.getEngine().equals(JEngine.V6);
    assert myCar.getGpsNavigator().equals(JGPSNavigator.T_MAP);
    assert myCar.getTransmission().equals(JTransmission.AUTO);

    myCar.drive();
  }
}

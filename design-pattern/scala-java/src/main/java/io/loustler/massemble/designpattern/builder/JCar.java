package io.loustler.massemble.designpattern.builder;

public class JCar {
  private final JType type;
  private final int seats;
  private final JEngine engine;
  private final JTransmission transmission;
  private final JGPSNavigator gpsNavigator;

  private JCar(
    JType type, int seats, JEngine engine,
    JTransmission transmission,
    JGPSNavigator gpsNavigator
  ) {
    this.type = type;
    this.seats = seats;
    this.engine = engine;
    this.transmission = transmission;
    this.gpsNavigator = gpsNavigator;
  }

  public static class Builder {
    private JType type_;
    private int seats_;
    private JEngine engine_;
    private JTransmission transmission_;
    private JGPSNavigator gpsNavigator_;

    public Builder setDefault() {
      return withType(JType.SEDAN)
        .withSeats(4)
        .withEngine(JEngine.V4)
        .withTransmission(JTransmission.AUTO)
        .withGpsNavigator(JGPSNavigator.HYUNDAI);
    }

    public Builder withType(JType type) {
      this.type_ = type;

      return this;
    }

    public Builder withSeats(int seats) {
      this.seats_ = seats;

      return this;
    }

    public Builder withEngine(JEngine engine) {
      this.engine_ = engine;

      return this;
    }

    public Builder withTransmission(JTransmission transmission) {
      this.transmission_ = transmission;

      return this;
    }

    public Builder withGpsNavigator(JGPSNavigator gpsNavigator) {
      this.gpsNavigator_ = gpsNavigator;

      return this;
    }

    public JCar build() {
      return new JCar(
        this.type_,
        this.seats_,
        this.engine_,
        this.transmission_,
        this.gpsNavigator_
      );
    }
  }

  public void drive() {
    System.out.println("drive");
  }

  public JType getType() {
    return type;
  }

  public int getSeats() {
    return seats;
  }

  public JEngine getEngine() {
    return engine;
  }

  public JTransmission getTransmission() {
    return transmission;
  }

  public JGPSNavigator getGpsNavigator() {
    return gpsNavigator;
  }

  public static Builder builder() {
    return new Builder().setDefault();
  }
}

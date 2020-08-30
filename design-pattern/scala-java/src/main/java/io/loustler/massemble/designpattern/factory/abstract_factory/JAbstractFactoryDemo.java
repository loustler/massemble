package io.loustler.massemble.designpattern.factory.abstract_factory;

public class JAbstractFactoryDemo {
  public static void main(String[] args) {
    final String os = System.getProperty("os.name").toLowerCase();

    final JAbstractFactory factory;

    if (os.contains("window")) factory = new WindowsJAbstractFactory();
    else factory = new LinuxJAbstractFactory();

    final JAbstractFactoryApp app = new JAbstractFactoryApp(factory);

    app.run();
  }
}

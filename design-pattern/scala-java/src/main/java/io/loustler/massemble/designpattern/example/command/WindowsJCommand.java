package io.loustler.massemble.designpattern.example.command;

public final class WindowsJCommand implements JCommand {
  @Override
  public void exec() {
    System.out.println("Windows Command");
  }
}

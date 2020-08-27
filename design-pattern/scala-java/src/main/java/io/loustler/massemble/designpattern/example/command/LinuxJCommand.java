package io.loustler.massemble.designpattern.example.command;

public final class LinuxJCommand implements JCommand {
  @Override
  public void exec() {
    System.out.println("Linux command");
  }
}

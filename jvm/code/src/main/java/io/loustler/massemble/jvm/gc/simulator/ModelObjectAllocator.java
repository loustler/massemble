package io.loustler.massemble.jvm.gc.simulator;

public class ModelObjectAllocator implements Runnable {
  private final int[][] allocated;
  private final int lifetime;

  public ModelObjectAllocator(final int x, final int y, final int liveFor) {
    allocated = new int[x][y];
    lifetime = liveFor;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(lifetime);
      System.err.printf("%d: %d", System.currentTimeMillis(), allocated.length);
    } catch (InterruptedException e) {
      System.out.println("interrupted");
    }
  }
}

package io.loustler.massemble.jvm.gc.simulator;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 이 시뮬레이터를 실행시키고 VisualVM 으로 모니터링
 */
public class ModelSimulator implements Runnable {
  private volatile boolean shutdown = false;

  private final double changeOfLongLived = 0.02;
  private final int multiplierForLongLived = 20;
  private final int x = 1024;
  private final int y = 1024;
  private final int mbPerSec = 50;
  private final int shortLivedMs = 100;
  private final int nThreads = 8;
  private final Executor exec = Executors.newFixedThreadPool(nThreads);

  public int lifetime() {
    if (Math.random() < changeOfLongLived) {
      return multiplierForLongLived * shortLivedMs;
    }

    return shortLivedMs;
  }

  @Override
  public void run() {
    final int mainSleep = (int)(1000.0 / mbPerSec);

    while(!shutdown) {
      for (int i = 0; i < mbPerSec; i++) {
        final ModelObjectAllocator to = new ModelObjectAllocator(x, y, lifetime());

        exec.execute(to);

        try {
          Thread.sleep(mainSleep);
        } catch (InterruptedException e) {
          shutdown = true;
        }
      }
    }
  }
}

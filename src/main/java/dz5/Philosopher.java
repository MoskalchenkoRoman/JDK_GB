package dz5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable{
    private final int maxEatCount;
    static int PHILOSOPHER_COUNT;
    private String name;
    private int eatCount;
    private CyclicBarrier barrier;
    final Lock lock;;

    public Philosopher(CyclicBarrier barrier, int maxEatCount, Lock lock) {
        this.barrier = barrier;
        this.lock = lock;
        PHILOSOPHER_COUNT++;
        this.maxEatCount = maxEatCount;
        this.name = "Философ #" + PHILOSOPHER_COUNT;
    }

    @Override
    public void run() {
        while (eatCount < maxEatCount) {
            try {
                thinking();
                lock.lock();
                System.out.println(name + " ушел кушать");
                eating();
            } finally {
                System.out.println(name + " вернулся");
                lock.unlock();
            }
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private void eating() {
        try {
            eatCount++;
            System.out.println(name + " трапезничал  " + eatCount + " раз(а)");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void thinking() {
        try {
            System.out.println(name + " мозгую");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

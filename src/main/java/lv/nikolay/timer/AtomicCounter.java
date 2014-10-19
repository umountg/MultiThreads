package lv.nikolay.timer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private AtomicInteger c = new AtomicInteger(0);
    private AtomicBoolean readyToPrint = new AtomicBoolean(false);
    private AtomicBoolean stopped = new AtomicBoolean(false);

    public boolean isStopped() {
        return stopped.get();
    }

    public void setStopped(boolean stopped) {
        this.stopped.set(stopped);
    }

    public synchronized void increment() {
        c.incrementAndGet();
        System.out.println("Increment called");
        setReadyToPrint(true);
        this.notify();

    }

    public void decrement() {
        c.decrementAndGet();
    }

    public synchronized int currentValue() {
        while (!isReadyToPrint()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setReadyToPrint(false);
        return c.get();
    }

    public void reset() {
        c.set(0);
    }

    public boolean isReadyToPrint() {
        return readyToPrint.get();
    }

    public void setReadyToPrint(boolean readyToPrint) {
        this.readyToPrint.set(readyToPrint);
    }

}

package lv.nikolay.timer;

public class Timer extends Thread {
    private AtomicCounter counter;

    public Timer(AtomicCounter counter) {
        this.counter = counter;
    }

    public void run() {
        while (!counter.isStopped()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            counter.increment();
        }
    }
}

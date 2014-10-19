package lv.nikolay.timer;

public class Printer extends Thread {
    private AtomicCounter counter;

    public Printer(AtomicCounter counter) {
        this.counter = counter;
    }

    public void run() {
        while (!counter.isStopped()) {
            System.out.println("Current counter value = " + counter.currentValue());
        }
    }
}





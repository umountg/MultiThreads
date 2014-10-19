package lv.nikolay.syncasync;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncEven implements Even{
    private AtomicInteger n = new AtomicInteger(0);

    public synchronized int next() {
        // POST CONDITION: next is always even
        n.getAndIncrement();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n.getAndIncrement();
        return n.get();
    }
}

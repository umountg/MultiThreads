package lv.nikolay.syncasync;

public class Sequence implements Runnable {
    private int getSeqNumb() {
        return even.next();
    }

    private Even even;

    public Sequence(Even even) {
        this.even = even;
    }

    @Override
    public void run() {
        System.out.println("Next value = " + even.next());
    }
}

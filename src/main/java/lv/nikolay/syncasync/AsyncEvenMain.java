package lv.nikolay.syncasync;

public class AsyncEvenMain {
    public static void main(String[] args) {
        AsyncEven asyncEven = new AsyncEven();

        for (int i = 0; i < 5; i++) {
            Sequence sq = new Sequence(asyncEven);
            Thread t = new Thread(sq);
            t.start();
        }
    }
}

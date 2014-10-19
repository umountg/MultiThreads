package lv.nikolay.syncasync;

/**
 * Created with IntelliJ IDEA.
 * User: nikoboro
 * Date: 13.26.7
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class SyncEvenMain {
    public static void main(String[] args) {
        SyncEven se = new SyncEven();
        for (int i = 0; i < 5; i++) {
            Sequence sq = new Sequence(se);
            Thread t = new Thread(sq);
            t.start();
        }
    }

}

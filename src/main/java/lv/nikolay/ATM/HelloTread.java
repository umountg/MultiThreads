package lv.nikolay.ATM;

/**
 * Created with IntelliJ IDEA.
 * User: MumboJumbo
 * Date: 7/22/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloTread implements Runnable {



    @Override
    public void run() {
//        Tread body
        for (int i = 1; i < 100500; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());


        for (int i = 1; i < 5; i++) {
            HelloTread th = new HelloTread();
            Thread t = new Thread(th);
            t.start();
        }
    }
}

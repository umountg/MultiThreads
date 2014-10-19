package lv.nikolay.ATM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MumboJumbo
 * Date: 7/22/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ATM implements Runnable {

    private BankAccount ba;
    private ATM atm;


    public ATM(BankAccount bankAccount) {
        this.ba = bankAccount;
    }

    @Override
    public void run() {

//        ba.checkOut(10);

//        synchronized (ba) {
            System.out.println("Before withraw = " + ba.getMoney());
            ba.setMoney(ba.getMoney() - 10);
            System.out.println("After withraw = " + ba.getMoney());
//        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount bAcc = new BankAccount(100);
        ATM atm = new ATM(bAcc);
        List<Thread> allThreads = new ArrayList<Thread>();

        for (int i = 1; i < 5; i++) {
            Thread t = new Thread(atm);
            allThreads.add(t);
            System.out.println(t.getName()+ "Alive");
            t.start();

        }

        for (Thread t : allThreads) {

            t.join();
            System.out.println(t.getName() + "dead");
        }

        System.out.println("ALL DEAD");
    }
}

package lv.nikolay.ATM;

/**
 * Created with IntelliJ IDEA.
 * User: MumboJumbo
 * Date: 7/22/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money;

    public BankAccount(int balance) {
        this.money = balance;
    }

    public synchronized void checkOut(int amount) {
        if (money >= amount) {
            money -= amount;
        }
        else throw new  RuntimeException("Zarabotaj snachalo!");


    }
}

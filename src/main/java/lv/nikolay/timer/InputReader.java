package lv.nikolay.timer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader extends Thread {
    private AtomicCounter counter;

    public InputReader(AtomicCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Scanner reader = new Scanner(System.in);
        int keyPressed = -1;
        while (keyPressed != 0) {
            System.out.println("Press 0 to exit...");
            try {
                keyPressed = reader.nextInt();
                if (keyPressed == 0) {
                        counter.setStopped(true);
                } else System.out.println("Do something else...");
            } catch (InputMismatchException e) {
                System.out.println("Menu item not exists!");
                reader.next();
            }
        }
    }
}

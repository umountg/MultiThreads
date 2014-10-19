package lv.nikolay.timer;

public class Main {

    public static void main (String [] args) {
        AtomicCounter counter = new AtomicCounter();

        // create new threads
        Thread timer = new Timer(counter);
        Thread printer = new Printer(counter);
        Thread inputReader = new InputReader(counter);

        // starting threads
        timer.start();
        printer.start();
        inputReader.start();

        // Wait for the threads to finish
        try {
            timer.join();
            printer.join();
//            inputReader.join();
        } catch (InterruptedException e) {return;}
    }

}

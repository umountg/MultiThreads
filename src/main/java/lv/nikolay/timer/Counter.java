package lv.nikolay.timer;

/**
 * Created with IntelliJ IDEA.
 * User: MumboJumbo
 * Date: 7/25/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Counter {

    void increment() ;

    void decrement();

    int currentValue();

    void reset();


}

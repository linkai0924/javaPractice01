package main.java.effectiveJava.Chapter10.item66;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by xiaokai on 2015/12/1.
 */
public class item66 {
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    /**
     * 这个方法的目的是要确保每个调用都返回不同的值,这个方法状态只包含一个可原子访问的域nextSerialNumber
     * 问题在于增量操作符++不是原子的，它在nextSerialNumber域中执行两项操作；
     * 首先它读取值，然后写回一个新值，
     * 相当于原来的值再加上1，如果第二个线程在第一个线程读取旧值和写回新值期间读取这个域，
     * 第二个线程就会与第一个线程一起看到同一个值，并返回相同的序列号。
     * 这就是安全性失败。
     * 修正generateSerailNumber方法的一种方法是在它的声明中增加synchronized修饰符
     */

    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long generateSerailNumber() {
        return nextSerialNum.getAndIncrement();
    }
    /**
     * 最好还是遵循第47条中的建议，使用类AtomicLong 并且可能比同步版的generateSerailNumber执行的更好。
     * */
}


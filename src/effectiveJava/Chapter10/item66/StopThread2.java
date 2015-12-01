package effectiveJava.Chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * 第66条 同步访问共享的可变数据
 * stopThread中被同步方法的动作即时没有同步也是原子的，换句话说，这些方法的同步只是为了它的通信结果，而不是
 * 为了互斥访问，虽然循环的每个迭代中的同步开销很小，还是有其他更正确的替代方法，它更简洁，性能也可能更好。
 * 如果stopRequested被声明为volatile，StopThread1中的锁就可以省略，虽然volatile修饰符不执行互斥访问，但它可以保证任何一个线程
 * 在读取该域的时候都将看到最近刚刚被写入的值。
 * Created by xiaokai on 2015/12/1.
 */
public class StopThread2 {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgoundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()) i++;
//                while (!stopRequested) i++;
            }
        });
        backgoundThread.start();
        TimeUnit.SECONDS.sleep(1);
//        stopRequested=true;
        requestStop();
    }


}

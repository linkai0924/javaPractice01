package effectiveJava.Chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * 第66条 同步访问共享的可变数据
 * 如果不加同步，你可能期待这个程序运行大约一秒钟，之后主线程将stopRequest设置为true,致使后台线程的循环终止。
 * 但实际情况是线程永远不会终止，问题在于由于没有同步，就不能保证后台线程何时看到主线程对stopRequest的值所做的改变
 * Created by xiaokai on 2015/12/1.
 */
public class StopThread1 {

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

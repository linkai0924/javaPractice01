package jdkSource.threadlocal;

public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println("main threadLocal.long = " + test.getLong() + " threadLocal.getString = " + test.getString());

        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println("thread threadLocal.long = " + test.getLong() + " threadLocal.getString = " + test.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }

    private void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    private long getLong() {
        return longLocal.get();
    }


    public String getString() {
        return stringLocal.get();
    }

}
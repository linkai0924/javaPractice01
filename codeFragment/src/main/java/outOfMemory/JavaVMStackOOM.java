package outOfMemory;

/**
 * VM Args：-Xss2M （这时候不妨设置大些）
 * Created by xiaokai on 2016/3/17.
 */
public class JavaVMStackOOM {

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
} 
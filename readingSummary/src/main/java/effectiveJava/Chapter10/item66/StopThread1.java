package effectiveJava.Chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * ��66�� ͬ�����ʹ���Ŀɱ�����
 * �������ͬ����������ڴ�����������д�Լһ���ӣ�֮�����߳̽�stopRequest����Ϊtrue,��ʹ��̨�̵߳�ѭ����ֹ��
 * ��ʵ��������߳���Զ������ֹ��������������û��ͬ�����Ͳ��ܱ�֤��̨�̺߳�ʱ�������̶߳�stopRequest��ֵ�����ĸı�
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

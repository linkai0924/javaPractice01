package main.java.effectiveJava.Chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * ��66�� ͬ�����ʹ���Ŀɱ�����
 * stopThread�б�ͬ�������Ķ�����ʱû��ͬ��Ҳ��ԭ�ӵģ����仰˵����Щ������ͬ��ֻ��Ϊ������ͨ�Ž����������
 * Ϊ�˻�����ʣ���Ȼѭ����ÿ�������е�ͬ��������С����������������ȷ�����������������࣬����Ҳ���ܸ��á�
 * ���stopRequested������Ϊvolatile��StopThread1�е����Ϳ���ʡ�ԣ���Ȼvolatile���η���ִ�л�����ʣ��������Ա�֤�κ�һ���߳�
 * �ڶ�ȡ�����ʱ�򶼽���������ոձ�д���ֵ��
 * Created by xiaokai on 2015/12/1.
 */
public class StopThread2 {

    private static volatile boolean stopRequested;

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
//                while (!stopRequested()) i++;
                while (!stopRequested) i++;
            }
        });
        backgoundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested=true;
    }


}

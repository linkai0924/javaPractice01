package jmx.demo.notification;

import jmx.demo.helloworld.Hello;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * Created by xiaokai on 2016/1/20.
 * 创建一个Listener，监听到的Notification消息包将由此类负责处理。
 */
public class HelloListener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("type=" + notification.getType());
        System.out.println("source=" + notification.getSource());
        System.out.println("seq=" + notification.getSequenceNumber());
        System.out.println("send time=" + notification.getTimeStamp());
        System.out.println("message=" + notification.getMessage());
        if(handback!=null){
            if(handback instanceof Hello){
                Hello hello= (Hello) handback;
                hello.pringHelo(notification.getMessage());
            }
        }
    }
}

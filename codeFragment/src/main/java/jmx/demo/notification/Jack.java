package jmx.demo.notification;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Created by xiaokai on 2016/1/20.
 * 3、Notification的使用
 * 一、简介
 * <p/>
 * Mbean之间的通信是必不可少的，Notification就起到了在Mbean之间沟通桥梁的作用。JMX notification 由四部分组成：
 * Notification 这个相当于一个信息包，封装了需要传递的信息
 * Notification broadcaster　这相当于一个广播器，把消息广播出去
 * Notification listerner　这是一个监听器，用于监听广播出来的Notification消息
 * Notification filter　这是一个过滤器，过滤掉不需要的Notification消息
 * 　 Notification broadcaster不需要我们实现，JMX的内部已经有了。Notification filter一般也很少用。下面的例子主要用到了Notification、Notification listerner。
 * <p/>
 * 二、实例
 * <p/>
 * 在第一篇的Hello中有一个printHello(String whoName)方法，意思根据碰到的是谁来打招呼，比如：
 * <p/>
 * Jack从对面走过来，说：“hi”
 * 　　我们回之以礼，说：“Hello, jack”
 * <p/>
 * 首先这需要Jack先说一个hi（相应一个操作方法），然后他说的话封装成声波（相当Notification消息包）传递出去。
 * 然后我们还要给Jakc装上一个监听器（Hello的耳朵？？^_^），这个监听器将捕捉到Jack的声波语音包，并进行相应处理，即说“Hello, jack”。
 * <p/>
 * 好，我们看看如何实现的：
 * <p/>
 * 我们把Jack写成一个MBean，如下
 * <p/>
 * 说明：
 * 必需继承NotificationBroadcasterSupport
 * 此类只有一个hi方法，方法只有两句：创建一个Notification消息包，然后将包发出去
 * 如果你还要在消息包上附加其他数据，Notification还有一个setUserData方法可供使用
 * <p/>
 * <p/>
 * 三、运行
 * 1、先运行HelloAgent启动服务，再打开浏览器输入网址：http://localhost:8082/，出现如下界面。1133701664014_6541.jpg
 * <p/>
 * 2、　进入“name=jack”项，然后单击“hi”按钮来执行它。这时Eclipse的console视图显示如下：
 * <p/>
 * 1133702044916_7117.jpg
 * 四、总结
 * <p/>
 * Notification和Java的事件模型是一样的，Notification和Java的事件模型相同的设计方式。
 * Notification在我们的实际项目中也用到了，象我们现在的给移动做的项目中（基于JMX实现)，
 * 分散在各地方的工作站的日志，就是通过Notification方式，把每条产生的日志封装在Notification中实时发回主控服务器的。实现了对各地工作站的集中的、实时的监控，非常实用。
 */
public class Jack extends NotificationBroadcasterSupport implements JackMBean {
    private int seq = 0;

    public void hi() {
        Notification n = new Notification(//创建一个信息包
                "jack.hi",//给这个Notification起个名称
                this,//由谁发出的Notification
                ++seq,//一系列通知中的序列号,可以设任意数值
                System.currentTimeMillis(),//发出时间
                "jack");//发出的消息文本
        sendNotification(n);//发出去
    }

}

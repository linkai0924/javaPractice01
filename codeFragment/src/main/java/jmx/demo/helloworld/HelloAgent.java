package jmx.demo.helloworld;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import jmx.demo.dynamicMBean.HelloDynamic;
import jmx.demo.notification.HelloListener;
import jmx.demo.notification.Jack;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * Created by xiaokai on 2016/1/20.
 * 1、JMX的Hello World
 * <p/>
 * 　　什么是JMX？在一篇网文中是这样说的："JMX(Java Management Extensions)是一个为应用程序植入管理功能的框架。JMX是一套标准的代理和服务，实际上，
 * 用户可以在任何Java应用程序中使用这些代理和服务实现管理"，这句话我现在看着还是不知所云，云里雾里。
 * <p/>
 * 　　我们还是从JMX能给我们提供什么好处入手来理解吧。举一个应用实例：在一个系统中常常会有一些配置信息，比如服务的IP地址，端口号什么的，那么如何来写这些代码呢？
 * 程序初哥一般是写死在程序里，到要改变时就去改程序，然后再编译发布；
 * 程序熟手则一般把这些信息写在一个配置文件里（JAVA一般都是*.properties文件），到要改变时只要改配置文件，但还是重新启动系统，以便读取配置文件里的新值；
 * 程序好手则会写一个段代码，把配置值缓存起来，系统在读值的时候，先看看配置文件有没有更动。如有更改则重读一遍，否则从缓存里读取值
 * 程序高手则懂得取物为我所用，用JMX！把配置属性集中在一个类，然后写一个叫MBean的东东，再配置一下就轻松搞定了。而且JMX自动提供了一个WEB页面来给你来改变这些配置信息。
 * <p/>
 * 二、准备工作
 * <p/>
 * 　　JMX是一份规范，SUN依据这个规范在JDK（1.3、1.4、5.0）提供了JMX接口。而根据这个接口的实现则有很多种，比如Weblogic的JMX实现、MX4J、JBoss的JMX实现。在SUN自己也实现了一份，不过在JDK1.4之前，这件JMX实现（一些JAR包）是可选的，你得去它的网站上下载。JDK5.0则内嵌了进来，安装JDK5.0就可以开发基于JMX的代码了。
 * 　　但JDK5.0并非包含所有SUN的关于JMX的代码，有一些工具类是排除在JDK5.0之外的。下面根据所使用的JDK版本情况，谈一谈开发环境的准备。
 * 1、JDK1.3、1.4
 * 　　去SUN网站下载SUN的JMX实现，共两个ZIP文件，下载网址：http://java.sun.com/products/JavaManagement/download.html。
 * （1）jmx-1_2_1-ri.zip
 * 　　　解压后的lib目录包含：jmxri.jar、jmxtools.jar
 * （2）jmx_remote-1_0_1_03-ri.zip
 * 　　　解压后的lib目录包含：jmxremote.jar、jmxremote_optional.jar、rmissl.jar
 * 　　如果在DOS下用命令行开发，则把这五个JAR包加入到classpath系统变量中。如果你用Eclipse开发，则把JAR包加入到项目属性的Libratries（库）引用中。
 * 2、JDK5.0
 * 　　JDK5.0的jre\lib\rt.jar已经包含了jmxri.jar、jmxremote.jar、rmissl.jar三个包的代码。如果你用到jmxtools.jar、jmxremote_optional.jar的类，则需要将这两个类加入到classpath或Eclipse的项目库引用中。
 * 3、我使用的开发环境：JDK5.0 ＋ Eclipse3.2。
 * 　　注：因为用到jmxtools.jar中的HtmlAdaptorServer类，所以将此包加入到项目库引用中。jmxremote_optional.jar暂时不用到，不管它。
 * <p/>
 * 说明：
 * 先创建了一个MBeanServer，用来做MBean的容器
 * 将Hello这个类注入到MBeanServer中，注入需要创建一个ObjectName类
 * 创建一个AdaptorServer，这个类将决定MBean的管理界面，这里用最普通的Html型界面。AdaptorServer其实也是一个MBean。
 * chengang:name=HelloWorld的名字是有一定规则的，格式为：“域名:name=MBean名称”，域名和MBean名称都可以任意取。
 * 在实际系统中我们可以把name变成决定数库链接池的变量，这样我就可以对系统的运行参数进行实现的监控和配置（管理）。
 * 而且也可以对一些方法（如printHello）进行远程调用了。
 */
public class HelloAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        /**1、helloworld*/
        ObjectName helloName = new ObjectName("HelloAgent:name=HelloWorld");
        Hello hello=new Hello();
        server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmlAdaptor,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        /**3、notification 使用*/
        Jack jack=new Jack();
        server.registerMBean(jack,new ObjectName("HelloAgent:name=jack"));
        jack.addNotificationListener(new HelloListener(),null,hello);

        /** 4、DynamicMBean */
        HelloDynamic helloDynamic=new HelloDynamic();
        ObjectName helloDynamicName = new ObjectName("HelloAgent:name=helloDynamic");
        server.registerMBean(helloDynamic,helloDynamicName);

        adapter.start();//启动
        System.out.println("start.......");
    }
}

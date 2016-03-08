package jdkSource.jmx.demo.apacheModule;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import jdkSource.jmx.demo.helloworld.Hello;
import org.apache.commons.modeler.ManagedBean;
import org.apache.commons.modeler.Registry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBean;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by xiaokai on 2016/1/21.
 * 5、用Apache的commons-modeler来辅助开发JMX
 * 一、前言
 * 每一个MBean都要有一个接口，比如前面的Hello要有一个HelloMBean接口。要多维护一个接口，的确是件麻烦的事。
 * Apache的commons-modeler利用JMX中的动态MBean原理很好的解决了这一问题，commons-modeler使用得我们可以只写Hello，而不用写HelloMBean这个接口。
 * 不过这是有代价的，它要求我们写一个mbean的xml描述文件（唉，少了一件事，却又多出另一件事来）。但commons-modeler还是有优点的，就是它让mbean的装配更加灵活，把多个mbean的装配都集中在一个XML文件里来了。
 * 　　开始实例之前，你需要先去apache网站下载commons-modeler，以及modeler的依赖项目commons-logging。
 * 下载网址为：http://jakarta.apache.org/site/downloads/downloads_commons.html，下载的文件是ZIP压缩包，解压后找到commons-logging.jar和commons-modeler.jar。
 * 如果在DOS下用命令行开发，则把这两个JAR包加入到classpath系统变量中。如果你用Eclipse开发，则把JAR包加入到项目属性的Libratries（库）引用中。
 * 二、HelloWorld实例
 * 　我们以本系统的第一篇“1、JMX的Hello World”为例，来重新实现一次。
 *
 * 2、MBean不用写了，但需要写一个XML描述文件。文件名任取，这里取名为：mbeans-descriptors
 *
 */
public class HelloAgent {
    public static void main(String[] args) throws Exception {
        //基于xml中的信息构建一个Registry
        Registry registry = Registry.getRegistry(null, null);
        InputStream stream = new FileInputStream("test.txt");
//        InputStream stream = HelloAgent.class.getResourceAsStream("mbeans-descriptors.xml");
        String path = HelloAgent.class.getResourceAsStream("mbeans-descriptors.xml").toString();
        registry.loadMetadata(stream);
        stream.close();
        //由Registry得到一个MBeanServer
        MBeanServer server = registry.getMBeanServer();
        //得到Hello在描述文件中的信息类，对应于xml文件<mbean>标签的name属性。
        ManagedBean managed = registry.findManagedBean("Hello");
        //创建ObjectName
        ObjectName helloName = new ObjectName(managed.getDomain() + ":name=HelloWorld");
        //得到ModelMBean
        ModelMBean hello = managed.createMBean(new Hello());
        //注册MBean
        server.registerMBean(hello, helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
        System.out.println("start.....");
    }
}

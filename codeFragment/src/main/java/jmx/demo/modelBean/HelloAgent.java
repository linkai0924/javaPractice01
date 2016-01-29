package jmx.demo.modelBean;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.modelmbean.RequiredModelMBean;

/**
 * 接下来是HelloAgent的写法，和以前就差一句：把“new Hello()”这一句删除了，加上了ModelMbeanUtils.createModlerMbean();
 */
public class HelloAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        //Hello hello = new Hello();
        RequiredModelMBean hello = ModelMBeanUtils.createModlerMBean();
        server.registerMBean(hello, helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
        System.out.println("start.....");
    }
}
import leader.domain.MyOrder;
import leader.service.HelloWorldBean2;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main9 {

    public static void main(String[] args) throws InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext3.xml");
        MyOrder myOrder = new MyOrder();
        HelloWorldBean2 h2 = myOrder.getHellBean();
        h2.hello();
        System.out.println(" isAopProxy  " + AopUtils.isAopProxy(myOrder));
        System.out.println(" isCglibProxy  " + AopUtils.isCglibProxy(myOrder));
        System.out.println(" isJdkDynamicProxy  " + AopUtils.isJdkDynamicProxy(myOrder));
        ctx.registerShutdownHook();

    }
}
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date() + "  begin");
//      HelloWorld helloworld = new HelloWorld();  
//      helloworld.setName("hfkjdshf");  

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Thread.sleep(5000);
        HelloWorldBean helloworld = (HelloWorldBean) ctx.getBean("helloBean");
        System.out.println(new Date() + " get bean " + helloworld);
        Thread.currentThread();
        Thread.sleep(5000);
        helloworld.hello();


    }
}  
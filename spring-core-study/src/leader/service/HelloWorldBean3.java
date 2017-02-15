package leader.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
//@Scope("prototype")
public class HelloWorldBean3 {

    public HelloWorldBean3() {
        System.out.println(new Date() + " created " + this);
    }

    @PostConstruct
    public void init() {
        System.out.println("inited ");
        // open jdbc pool ,or thread pool

    }

    public void hello() {
        System.out.println(new Date() + " hellow " + " @ " + this);

    }

    @PreDestroy
    public void close() {
        System.out.println("closed ");
        // close jdbc pool ,or thread pool  ,release resource
    }
}

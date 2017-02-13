package leader.domain;

import leader.service.HelloWorldBean2;
import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.Resource;

@Configurable
public class MyOrder {

    @Resource
    private HelloWorldBean2 hellBean;

    public HelloWorldBean2 getHellBean() {
        return hellBean;
    }

}

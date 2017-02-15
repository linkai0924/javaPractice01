package test;

import leader.service.HelloWorldBean3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:/applicationContext2.xml")
public class Test2 {

    @Autowired
    private HelloWorldBean3 hellBean3;

    @Test
    public void test1() {
        hellBean3.hello();
    }
}

package leader;

import leader.bean.User;
import leader.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by xiaokai on 2017/2/15.
 */
public class maintest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setEnabled(true);
        user.setUserId(1);
        user.setPassword("123456");
        user.setRegDate(new Date());
        user.setUserName("linkai");
        userService.createUser(user);
    }
}

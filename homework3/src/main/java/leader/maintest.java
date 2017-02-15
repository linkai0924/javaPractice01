package leader;

import leader.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaokai on 2017/2/15.
 */
public class maintest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = new UserService();
        userService.login();
    }
}

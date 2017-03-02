package leader;

import leader.server.HTTPServer;

/**
 * Created by xiaokai on 2017/2/15.
 */
public class maintest {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) ctx.getBean("userService");
//        User user = new User();
//        user.setEnabled(true);
//        user.setUserId(1);
//        user.setPassword("123456");
//        user.setRegDate(new Date());
//        user.setUserName("linkai");
//        userService.createUser(user);
//        System.out.println(userService.getUser(user.getUserName()));
//        System.out.println(userService.login(user));
//        System.out.println(SessionMap.getUserSession(user.getUserId() + user.getUserName()));
        HTTPServer httpServer = new HTTPServer();
        httpServer.service(8888);
    }
}

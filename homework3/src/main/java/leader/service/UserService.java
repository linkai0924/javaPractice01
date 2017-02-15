package leader.service;

import leader.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService extends leader.service.AbstractService<User> {

    @Autowired
    private UserService userService;

    public void login() {
        System.out.println("login");
//        userService.createUser(user);
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

}

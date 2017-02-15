package leader.service;

import leader.bean.User;
import org.springframework.stereotype.Component;

@Component
public class UserService extends leader.service.AbstractService<User> {


    public void login() {
        System.out.println("login");
    }

    public void createUser(User user){

    }

}

package leader.service;

import leader.bean.User;
import leader.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService extends leader.service.AbstractService<User> {

    @Resource
    private UserDao userDao;

    public void login() {

        System.out.println("login");
    }

    public void createUser(User user) {
        userDao.createDomainObj(user);
    }

    public void updateUser(User user) {
//        userService.createUser(user);
    }

}

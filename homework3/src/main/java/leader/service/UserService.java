package leader.service;

import leader.bean.SessionMap;
import leader.bean.User;
import leader.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService extends leader.service.AbstractService<User> {

    @Resource
    private UserDao userDao;

    public boolean login(User user) {
        User userLogin = userDao.selectDomainObj(user.getUserName());
        if (userLogin.getPassword().equals(user.getPassword())) {
            SessionMap.setUserSession(user);
            return true;
        }
        return false;
    }

    public void createUser(User user) {
        userDao.createDomainObj(user);
    }

    public void updateUser(User user) {
//        userService.createUser(user);
    }

    public User getUser(String userName) {
        return userDao.selectDomainObj(userName);
    }

}

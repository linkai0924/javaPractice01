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

    public boolean createUser(User user) {
        User userLogin = userDao.selectDomainObj(user.getUserName());
        if (userLogin != null) {
            System.out.println("用户名已经存在");
            return false;
        }
        userDao.createDomainObj(user);
        return true;
    }

    public boolean deleteUser(String userName) {
        userDao.deleteDomainObj(userName);
        return true;
    }

    public void updateUser(User user) {


    }

    public User getUser(String userName) {
        return userDao.selectDomainObj(userName);
    }

}

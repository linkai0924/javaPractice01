package leader.bean;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by linkai on 2017/2/16.
 */
public class SessionMap {

    private static HashMap<String, UserSession> sessionMap = new HashMap();

    private static final short validtime = 100;

    public static UserSession getUserSession(String key) {
        return sessionMap.get(key);
    }

    public static void setUserSession(User user) {
        UserSession userSession = new UserSession();
        userSession.setSessionId(user.getUserId()+user.getUserName());
        userSession.setUserName(user.getUserName());
        userSession.setUserId(user.getUserId());
        userSession.setCreateTime(new Date().getTime());
        userSession.setValidSeconds(validtime);
        sessionMap.put(userSession.getSessionId(), userSession);
    }


}

package leader.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import leader.bean.User;
import leader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;


/**
 * http 方法处理类
 */
public class RequestProcessor implements Runnable {

    private static List pool = new LinkedList();
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void processRequest(Socket request) {
        synchronized (pool) {
            pool.add(pool.size(), request);
            pool.notifyAll();
        }
    }

    public RequestProcessor(ApplicationContext ctx, int no) {
        System.out.println(no);
        this.ctx = ctx;
    }

    @Override
    public void run() {
        while (true) {
            Socket connection;
            synchronized (pool) {
                while (pool.isEmpty()) {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                connection = (Socket) pool.remove(0);
            }

            try {
                String pathName;
                PrintWriter writer = new PrintWriter(connection.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder request = new StringBuilder(200);
                while (true) {
                    int c = in.read();
                    if (c == '\t' || c == '\n' || c == -1) {
                        break;
                    }
                    request.append((char) c);
                }

                String get = request.toString();
                //记录日志
                System.out.println(get);

                StringTokenizer st = new StringTokenizer(get);
                String method = st.nextToken();
                pathName = st.nextToken();
                int begin = pathName.indexOf("/") + 1;
                int end = pathName.contains("?") ? pathName.indexOf("?") : pathName.length();
                String path = pathName.substring(begin, end);
                Map<String, String> resultMap = Maps.newHashMap();
                User user = null;
                if ("GET".equalsIgnoreCase(method)) {
                    if (pathName.contains("?")) {
                        String args = pathName.substring(pathName.indexOf("?") + 1, pathName.length());
                        String decodeArgs = URLDecoder.decode(args, "UTF-8");
                        user = JSON.toJavaObject(JSON.parseObject(decodeArgs), User.class);
                    }
                    handleReuqest(path, resultMap, user);
                } else if (method.equals("POST")) {
                    String line;
                    StringBuilder content = new StringBuilder();
                    Integer contentLength = 0;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        content.append(line);
                        if (line.toLowerCase().contains("content-length:")) {
                            contentLength = Integer.parseInt(line.substring(16, line.length()));
                        }
                    }
                    String objectStr = content.toString().substring(content.length() - contentLength, content.length());
                    user = JSON.toJavaObject(JSON.parseObject(objectStr), User.class);
                    handleReuqest(path, resultMap, user);
                } else {
                    resultMap.put("code", "-1");
                    resultMap.put("data", "unknown method");
                    resultMap.put("msg", "error");
                }
                writer.println(JSON.toJSONString(resultMap));
                writer.flush();
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }
        }
    }

    private void handleReuqest(String path, Map<String, String> resultMap, User user) {
        UserService userService = (UserService) ctx.getBean("userService");
        switch (path) {
            case "createUser":
                if (user == null) {
                    resultMap.put("code", "-1");
                    resultMap.put("data", null);
                    resultMap.put("msg", "input args is wrong");
                } else {
                    if (userService.createUser(user)) {
                        resultMap.put("code", "0");
                        resultMap.put("data", null);
                        resultMap.put("msg", "success");
                    } else {
                        resultMap.put("code", "-1");
                        resultMap.put("data", "添加用户失败");
                        resultMap.put("msg", "error");
                    }
                }
                break;
            case "login":
                boolean tag = userService.login(user);
                if (tag) {
                    resultMap.put("code", "0");
                    resultMap.put("data", JSON.toJSONString(user));
                    resultMap.put("msg", "success");
                }
                break;
//                        case "updateUser":
//                            userService.updateUser(user);
//
//                            break;
//                        case "deleteUser":
//                            userService.deleteUser(user.getUserName());
//                            break;

            default:
                resultMap.put("code", "-1");
                resultMap.put("data", "unknown method");
                resultMap.put("msg", "error");
                break;
        }
    }

}

package leader.server;

import leader.controller.HandleGetController;
import leader.controller.HandlePostController;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.request -> http包解析
 * 2.读取资源，处理请求，封装http包
 * 3.返回 -> response
 */
public class HTTPServer {


    @Autowired
    private HandleGetController handleGetController;

    @Autowired
    private HandlePostController handlePostController;

    /**
     * server处理方法
     *
     * @param port
     */
    public void service(int port) {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket socket = ss.accept();
                BufferedReader bd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                /**
                 * 接受HTTP请求
                 */
                String requestHeader;
                int contentLength = 0;
                while ((requestHeader = bd.readLine()) != null && !requestHeader.isEmpty()) {
                    System.out.println(requestHeader);
                    /**
                     * 处理GET请求
                     */
                    if (requestHeader.startsWith("GET")) {
//                        handleGetController.work
//                        IndexController
                        int index = requestHeader.indexOf("/?");
                        if (index == -1) {
                            System.out.println("GET参数是：" + "null");
                        } else {
                            int begin = requestHeader.indexOf("/?") + 2;
                            int end = requestHeader.indexOf("HTTP/");
                            String condition = requestHeader.substring(begin, end);
                            System.out.println("GET参数是：" + condition);
                        }
                    }
                    /**
                     * 处理POST请求
                     */
                    if (requestHeader.startsWith("Content-Length")) {
                        int begin = requestHeader.indexOf("Content-Lengh:") + "Content-Length:".length();
                        String postParamterLength = requestHeader.substring(begin).trim();
                        contentLength = Integer.parseInt(postParamterLength);
                        System.out.println("POST参数长度是：" + Integer.parseInt(postParamterLength));
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (contentLength > 0) {
                    for (int i = 0; i < contentLength; i++) {
                        sb.append((char) bd.read());
                    }
                    System.out.println("POST参数是：" + sb.toString());
                }
                //发送回执
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println("HTTP/1.1 200 OK");
                pw.println("Content-type:text/html");
                pw.println();
                pw.println("<h1>访问成功！</h1>");
                pw.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
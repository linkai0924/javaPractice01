package leader.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import leader.controller.DispatcherController;

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


    private DispatcherController dispatcherController = new DispatcherController();

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
                System.out.println(JSON.toJSONString(socket));
                /**
                 * 接受HTTP请求
                 */
                String requestHeader;
                JSONObject jsonObject = new JSONObject();
                while ((requestHeader = bd.readLine()) != null && !requestHeader.isEmpty()) {
                    System.out.println(JSON.toJSONString(requestHeader));
                    /**
                     * 处理GET请求
                     */
                    if (requestHeader.startsWith("GET")) {
                        jsonObject = dispatcherController.handleGetRequest(requestHeader);
                    }
                    /**
                     * 处理POST请求
                     */
                    if (requestHeader.startsWith("POST")) {
                        jsonObject = dispatcherController.handlePostRequest(requestHeader,bd);
                    }
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 5; i++) {
                    sb.append((char) bd.read());
                }
                System.out.println("POST参数是：" + sb.toString());
                //发送回执
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.print(jsonObject);
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
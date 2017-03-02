package leader.server;

import leader.controller.DispatcherController;
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
    private DispatcherController dispatcherController;

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
                while ((requestHeader = bd.readLine()) != null && !requestHeader.isEmpty()) {
                    System.out.println(requestHeader);
                    /**
                     * 处理GET请求
                     */
                    if (requestHeader.startsWith("GET")) {
                        dispatcherController.handleGetRequest(requestHeader);
                    }
                    /**
                     * 处理POST请求
                     */
                    if (requestHeader.startsWith("POST /")) {
                        dispatcherController.handlePostRequest(requestHeader);
                    }
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
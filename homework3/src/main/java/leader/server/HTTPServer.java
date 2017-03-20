package leader.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class HTTPServer extends Thread {

    private ServerSocket server;
    private int numThreads = 10;//线程数
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    public HTTPServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    public void run() {
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(new RequestProcessor(ctx,i));
            t.start();
        }
        System.out.println("Accepting connection on port " + server.getLocalPort());
        while (true) {
            try {
                Socket request = server.accept();
                RequestProcessor.processRequest(request);
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8888;
        try {
            HTTPServer webserver = new HTTPServer(port);
            webserver.start();
        } catch (IOException e) {
            System.out.println("Server could not start because of an " + e.getClass());
            e.printStackTrace();
        }

    }

}


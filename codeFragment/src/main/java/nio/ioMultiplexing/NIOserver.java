package nio.ioMultiplexing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * NIO服务端
 * Created by xiaokai on 2016/3/2.
 */
public class NIOserver {
    //channel通道管理器
    private Selector selector;

    //获得一个ServerSocket通道 并对该通道做初始化
    public void initServer(int port) throws IOException {
        //获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector=Selector.open();
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public void listen() throws IOException{
        System.out.println("服务端启动成功");
        //轮训访问selector channel
        while(true){
            selector.select();

        }
    }


}

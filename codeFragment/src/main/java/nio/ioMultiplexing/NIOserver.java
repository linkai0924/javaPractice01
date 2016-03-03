package nio.ioMultiplexing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO服务端
 * Java NIO非堵塞技术实际是采取Reactor模式，
 * 或者说是Observer模式为我们监察I/O端口，
 * 如果有内容进来，会自动通知我们，这样，我们就不必开启多个线程死等，从外界看，实现了流畅的I/O读写，不堵塞了
 * Created by xiaokai on 2016/3/2.
 */
public class NIOserver {
    //channel通道管理器
    private Selector selector;

    public static void main(String[] args) throws IOException {
        NIOserver server = new NIOserver();
        server.initServer(8000);
        server.listen();
    }

    //获得一个ServerSocket通道 并对该通道做初始化
    public void initServer(int port) throws IOException {
        //获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //获得一个通道管理器
        this.selector = Selector.open();
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 采用轮训的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("服务端启动成功");
        //轮训访问selector channel
        while (true) {
            //当注册的事件到达时，方法返回，否则，该方法会一直阻塞
            selector.select();
            //获取selector中选中的项的迭代器，选中的项为注册的事件
            Iterator iter = this.selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key = (SelectionKey) iter.next();
                //删除已选的key，以防止重复处理
                iter.remove();
                //客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    //设置成非阻塞
                    channel.configureBlocking(false);
                    //字节流向客户端发送消息
                    /**
                     * ByteBuffer俗称缓冲器， 是将数据移进移出通道的唯一方式，并且我们只能创建一个独立的基本类型缓冲器，
                     * 或者使用“as”方法从 ByteBuffer 中获得。ByteBuffer 中存放的是字节，
                     * 如果要将它们转换成字符串则需要使用 Charset ，
                     * Charset 是字符编码，它提供了把字节流转换成字符串 ( 解码 ) 和将字符串转换成字节流 ( 编码) 的方法。
                     * */
                    channel.write(ByteBuffer.wrap(new String("sendmessagetoclient").getBytes()));
                    //在和客户端连接成功之后，为了可以接收客户端消息，需要给通道设置读的权限
                    channel.register(this.selector, SelectionKey.OP_READ);
                    //获取了可读事件
                } else if (key.isReadable()) {
                    read(key);
                }
            }

        }
    }

    /**
     * 处理读取客户端发来的消息的事件
     * @param key
     * @throws IOException
     */
    public void read(SelectionKey key) throws IOException {
        //服务器可读取消息，得到事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端接收到信息：" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);//将消息会送给客户端
    }


}

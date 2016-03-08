服务器端编程经常需要构造高性能的IO模型，常见的IO模型有四种：
----


> 1.同步阻塞IO（Blocking IO）：即传统的IO模型。
_Java BIO ： 同步并阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，
如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善。_

> 2.同步非阻塞IO（Non-blocking IO）：默认创建的socket都是阻塞的，非阻塞IO要求socket被设置为NONBLOCK。注意这里所说的NIO并非Java的NIO（New IO）库。
_Java NIO ： 同步非阻塞，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，
多路复用器轮询到连接有I/O请求时才启动一个线程进行处理。_

> 3.IO多路复用（IO Multiplexing）：即经典的Reactor设计模式，有时也称为异步阻塞IO，Java中的Selector和Linux中的epoll都是这种模型。

> 4.异步IO（Asynchronous IO）：即经典的Proactor设计模式，也称为异步非阻塞IO。
_Java AIO(NIO.2) ： 异步非阻塞，服务器实现模式为一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理_


#### BIO、NIO、AIO适用场景分析:
* BIO方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前的唯一选择，但程序直观简单易理解。
* NIO方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，JDK1.4开始支持。
* AIO方式使用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用OS参与并发操作，编程比较复杂，JDK7开始支持

> ###see:
[IO设计模式：Reactor和Proactor对比](http://www.cnblogs.com/me115/p/4452801.html)
[Netty 权威指南》—— 服务端序列图](http://ifeve.com/netty-2-3-2/)
[Java AIO 例子](http://colobu.com/2014/11/13/java-aio-introduction/) 
______
步骤一：打开ServerSocketChannel，用于监听客户端的连接，它是所有客户端连接的父管道
步骤二：绑定监听端口，设置连接为非阻塞模式
步骤三：创建Reactor线程，创建多路复用器并启动线程
步骤四：将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听ACCEPT事件
步骤五：多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
步骤六：多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路
步骤七：设置客户端链路为非阻塞模式
步骤八：将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，用来读取客户端发送的网络消息
步骤九：异步读取客户端请求消息到缓冲区
步骤十：对ByteBuffer进行编解码，如果有半包消息指针reset，继续读取后续的报文，将解码成功的消息封装成Task，投递到业务线程池中，进行业务逻辑编排
步骤十一：将POJO对象encode成ByteBuffer，调用SocketChannel的异步write接口，将消息异步发送给客户端

 

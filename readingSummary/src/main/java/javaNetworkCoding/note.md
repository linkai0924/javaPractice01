#目录结构
1. 基本网络概念
![image](http://img0.ph.126.net/TpiBVI76tYdR8KK4wmoViA==/6631550451306087348.png)
![tcp ip](http://img1.ph.126.net/jGgXmjKzJgA8PiIHjolHyg==/6631718676585104341.png)
linux 系统中 /etc/services文件存储了一份相当完整的端口分配列表
![已知端口分配](http://img2.ph.126.net/O-zPrsPDXg8ozIRe5a44dQ==/6631570242515389577.png)


2. 流
3. 线程
4. Internet 地址
5. URL和URI
6. HTTP
7. URLConnection
8. 客户端Socket
9. 服务器Socket
10. 安全Socket
11. 非阻塞I/O
12. UDP

> Keep-alive: http1.0 会为每个请求打开一个新连接，实际上，一个典型的web会话中打开和关闭所有连接所花费的时间
远远大于实际传输数据的时间，特别是有很多小文档的会话。对于使用SSL或TLS的加密HTTPS连接这个问题尤其严重，因为建立
一个安全socket的握手过程比建立常规的socket需要更多工作。在http1.1和以后的版本中，服务器不必在发送响应后就关闭连接。
可以保持连接打开，在同一个socket上等待来自客户端的新请求。可以在一个TCP连接上连续发送多个请求和响应。不过，服务器响应之后，
客户端请求的锁步模式还是一样的。客户可以在HTTP请求首部中包含一个connection字段，指定值为Keep-alive,指示它希望
重用一个socket. java URL类透明支持HTTP keep-alive 除非显示的关闭这个特性。也就是说，在服务器关闭连接之前，如果
再次连接到同一个服务器，就会重用socket. 可以利用多个系统属性来控制java如何使用 http keep-alive


> socket允许程序员将网络连接看做是另一个可以读、写的字节的流。socket对程序员掩盖了网络的底层细节
如错误检测、包大小、包分解、包重传、网络地址等。

>套接字（socket）是通信的基石，是支持TCP/IP协议的网络通信的基本操作单元。
它是网络通信过程中端点的抽象表示，包含进行网络通信必须的五种信息：
连接使用的协议，本地主机的IP地址，本地进程的协议端口，远地主机的IP地址，远地进程的协议端口。
应用层通过传输层进行数据通信时，TCP会遇到同时为多个应用程序进程提供并发服务的问题。
多个TCP连接或多个应用程序进程可能需要通过同一个 TCP协议端口传输数据。为了区别不同的应用程序进程和连接，
许多计算机操作系统为应用程序与TCP／IP协议交互提供了套接字(Socket)接口。应用层可以和传输层通过Socket接口，区分来自不同应用程序进程或网络连接的通信，实现数据传输的并发服务。
创建Socket连接时，可以指定使用的传输层协议，Socket可以支持不同的传输层协议（TCP或UDP），当使用TCP协议进行连接时，该Socket连接就是一个TCP连接。
socket则是对TCP/IP协议的封装和应用（程序员层面上）。也可以说，TPC/IP协议是传输层协议，主要解决数据 如何在网络中传输，而HTTP是应用层协议，主要解决如何包装数据。关于TCP/IP和HTTP协议的关系，网络有一段比较容易理解的介绍：
“我们在传输数据时，可以只使用（传输层）TCP/IP协议，但是那样的话，如 果没有应用层，便无法识别数据内容，如果想要使传输的数据有意义，则必须使用到应用层协议，应用层协议有很多，比如HTTP、FTP、TELNET等，也 可以自己定义应用层协议。WEB使用HTTP协议作应用层协议，以封装HTTP文本信息，然后使用TCP/IP做传输层协议将它发到网络上。”
我们平时说的最多的socket是什么呢，实际上socket是对TCP/IP协议的封装，Socket本身并不是协议，而是一个调用接口（API），通过Socket，我们才能使用TCP/IP协议。 
实际上，Socket跟TCP/IP协议没有必然的联系。Socket编程接口在设计的时候，就希望也能适应其他的网络协议。
所以说，Socket的出现 只是使得程序员更方便地使用TCP/IP协议栈而已，是对TCP/IP协议的抽象，从而形成了我们知道的一些最基本的函数接口，
比如create、 listen、connect、accept、send、read和write等等。网络有一段关于socket和TCP/IP协议关系的说法比较容易理解

>Socket连接与HTTP连接
>> 
由于通常情况下Socket连接就是TCP连接，因此Socket连接一旦建立，通信双方即可开始相互发送数据内容，直到双方连接断开。但在实际网络应用中，客户端到服务器之间的通信往往需要穿越多个中间节点，例如路由器、网关、防火墙等，大部分防火墙默认会关闭长时间处于非活跃状态的连接而导致 Socket 连接断连，因此需要通过轮询告诉网络，该连接处于活跃状态。
而HTTP连接使用的是“请求—响应”的方式，不仅在请求时需要先建立连接，而且需要客户端向服务器发出请求后，服务器端才能回复数据。
很多情况下，需要服务器端主动向客户端推送数据，保持客户端与服务器数据的实时与同步。此时若双方建立的是Socket连接，服务器就可以直接将数据传送给客户端；若双方建立的是HTTP连接，则服务器需要等到客户端发送一次请求后才能将数据传回给客户端，因此，客户端定时向服务器端发送连接请求，不仅可以保持在线，同时也是在“询问”服务器是否有新的数据，如果有就将数据传给客户端。
http协议是应用层的协义 
有个比较形象的描述：HTTP是轿车，提供了封装或者显示数据的具体形式；Socket是发动机，提供了网络通信的能力

HTTP协议：简单对象访问协议，对应于应用层  ，HTTP协议是基于TCP连接的
tcp协议：    对应于传输层
ip协议：     对应于网络层
TCP/IP是传输层协议，主要解决数据如何在网络中传输；而HTTP是应用层协议，主要解决如何包装数据。
Socket是对TCP/IP协议的封装，Socket本身并不是协议，而是一个调用接口（API），通过Socket，我们才能使用TCP/IP协议。
http连接：http连接就是所谓的短连接，即客户端向服务器端发送一次请求，服务器端响应后连接即会断掉；
socket连接：socket连接就是所谓的长连接，理论上客户端和服务器端一旦建立起连接将不会主动断掉；
但是由于各种环境因素可能会是连接断开，比如说：服务器端或客户端主机down了，网络故障，或者两者之间长时间没有数据传输，
网络防火墙可能会断开该连接以释放网络资源。所以当一个socket连接中没有数据的传输，那么为了维持连接需要发送心跳消息具体心跳消息格式是开发者自己定义的

 



# netty 的四个主要部分
## 1.Bootstrap 
配置并启动服务的类
## 2.Eventloop 
NioEventLoopGroup is a multithreaded event loop that handles I/O operation. 
Netty provides various EventLoopGroup implementations for different kind of transports
## 3.Channel 
核心部分，处理连接 
Channel是理解和使用Netty的核心
## 4.Buffer 缓冲相关类，对NIO Buffer做了一些封装

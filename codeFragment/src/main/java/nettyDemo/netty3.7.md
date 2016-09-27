Netty和Mina是Java世界非常知名的通讯框架。
它们都出自同一个作者，Mina诞生略早，属于Apache基金会，而Netty开始在Jboss名下，后来出来自立门户netty.io。
关于Mina已有@FrankHui的Mina系列文章。

Netty目前有两个分支：4.x和3.x。4.0分支重写了很多东西，并对项目进行了分包，规模比较庞大，入手会困难一些，而3.x版本则已经被广泛使用。
本系列文章针对netty 3.7.0 final。3.x和4.0的区别可以参考这篇文章：http://www.oschina.net/translate/netty-4-0-new-and-noteworthy?print

[Netty那点事（一）概述](http://my.oschina.net/flashsword/blog/162936)
[Netty那点事（二）Netty中的buffer](http://my.oschina.net/flashsword/blog/164237)
[Netty那点事（三）Channel与Pipeline](http://my.oschina.net/flashsword/blog/178561)
github:<https://github.com/code4craft/netty-learning>

-----------------------------------------------------

### netty源码目录

```
org
 └── jboss
     └── netty
         ├── bootstrap 配置并启动服务的类
         ├── buffer 缓冲相关类，对NIO Buffer做了一些封装
         ├── channel 核心部分，处理连接
         ├── container 连接其他容器的代码
         ├── example 使用示例
         ├── handler 基于handler的扩展部分，实现协议编解码等附加功能
         ├── logging 日志
         └── util 工具类
```
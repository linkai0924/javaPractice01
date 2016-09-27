# netty 的四个主要部分
1. Bootstrap 
配置并启动服务的类
2. Eventloop 
NioEventLoopGroup is a multithreaded event loop that handles I/O operation. 
Netty provides various EventLoopGroup implementations for different kind of transports
3. Channel 
核心部分，处理连接 
Channel是理解和使用Netty的核心
4. Buffer 缓冲相关类，对NIO Buffer做了一些封装

# Examples 4.1 Edition 
[wiki](http://netty.io/wiki/)
### Fundamental
* Echo ‐ the very basic client and server [demo](http://netty.io/4.1/xref/io/netty/example/echo/package-summary.html)
* Discard ‐ see how to send an infinite data stream asynchronously without flooding the write buffer [demo](http://netty.io/4.1/xref/io/netty/example/discard/package-summary.html)
* Uptime ‐ implement automatic reconnection mechanism [demo](http://netty.io/4.1/xref/io/netty/example/uptime/package-summary.html)
### Text protocols
* Telnet ‐ a classic line-based network application [demo](http://netty.io/4.1/xref/io/netty/example/telnet/package-summary.html)
* Quote of the Moment ‐ broadcast a UDP/IP packet [demo](http://netty.io/4.1/xref/io/netty/example/qotm/package-summary.html)
* SecureChat ‐ an TLS-based chat server, derived from the Telnet example [demo](http://netty.io/4.1/xref/io/netty/example/securechat/package-summary.html)
### Binary protocols
* ObjectEcho ‐ exchange serializable Java objects [demo](http://netty.io/4.1/xref/io/netty/example/objectecho/package-summary.html)
* Factorial ‐ write a stateful client and server with a custom binary protocol [demo](http://netty.io/4.1/xref/io/netty/example/factorial/package-summary.html)
* WorldClock ‐ rapid protocol protyping with Google Protocol Buffers integration [demo](http://netty.io/4.1/xref/io/netty/example/worldclock/package-summary.html)
### HTTP
* Snoop ‐ build your own extremely light-weight HTTP client and server [demo](http://netty.io/4.1/xref/io/netty/example/http/snoop/package-summary.html)
* File server ‐ asynchronous large file streaming in HTTP [demo](http://netty.io/4.1/xref/io/netty/example/http/file/package-summary.html)
* Web Sockets (Client & Server) ‐ add a two-way full-duplex communication channel to HTTP using Web Sockets [client](http://netty.io/4.1/xref/io/netty/example/http/websocketx/client/package-summary.html) [server](http://netty.io/4.1/xref/io/netty/example/http/websocketx/server/package-summary.html)
* SPDY (Client & Server) ‐ implement SPDY protocol [client](http://netty.io/4.1/xref/io/netty/example/spdy/client/package-summary.html) [server](http://netty.io/4.1/xref/io/netty/example/spdy/server/package-summary.html)
* CORS demo ‐ implement cross-origin resource sharing [demo](http://netty.io/4.1/xref/io/netty/example/http/cors/package-summary.html)
### Advanced
* Proxy server ‐ write a highly efficient tunneling proxy server [demo](http://netty.io/4.1/xref/io/netty/example/proxy/package-summary.html)
* Port unification ‐ run services with different protocols on a single TCP/IP port [demo](http://netty.io/4.1/xref/io/netty/example/portunification/package-summary.html)
### UDT
* Byte streams ‐ use UDT in TCP-like byte streaming mode [demo](http://netty.io/4.1/xref/io/netty/example/udt/echo/bytes/package-summary.html)
* Message flow ‐ use UDT in UDP-like message delivery mode [demo](http://netty.io/4.1/xref/io/netty/example/udt/echo/message/package-summary.html)
* Byte streams in symmetric peer-to-peer rendezvous connect mode [demo](http://netty.io/4.1/xref/io/netty/example/udt/echo/rendezvousBytes/package-summary.html)
* Message flow in symmetric peer-to-peer rendezvous connect mode [demo](http://netty.io/4.1/xref/io/netty/example/udt/echo/rendezvous/package-summary.html)

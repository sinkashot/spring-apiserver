package com.sinkashot.api;

import java.net.InetSocketAddress;

import com.sinkashot.api.handler.MyServerHandler;
import com.sinkashot.api.service.MyCallBack;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

public class NettyApplication {

	private static final String HOST = "0.0.0.0";
	private static final int PORT = 12000;	//server port
	private static final int READ_TIME_OUT = 60;
	private static final int WRITE_TIME_OUT = 30;

	public static void main(String[] args) {
		NettyApplication app = new NettyApplication();
		MyServerHandler handler = app.makeCallbackToDo();
		app.init(handler);
	}
	
	public MyServerHandler makeCallbackToDo() {
		return new MyServerHandler(new MyCallBack() {
			public void connect(ChannelHandlerContext ctx) {
				System.out.println("connect.");
			}
			public void read(String read) {
				System.out.print("server received : " + read);
			}
			public String write(String msg) {
				String result = "-> server send : "+msg+"\n";
				return result;
			}
			public void disconnect(ChannelHandlerContext ctx) {
				System.out.println("disconnected.");
			}
		});
	}
	
	public void init(final MyServerHandler handler) {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(HOST, PORT));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast("ReadTimeoutHandler", new ReadTimeoutHandler(READ_TIME_OUT));  
                    socketChannel.pipeline().addLast("WriteTimeoutHandler", new WriteTimeoutHandler(WRITE_TIME_OUT));  
                    socketChannel.pipeline().addLast("myHandler", handler);       
                }
            })
            .option(ChannelOption.SO_BACKLOG, 128)  //동시 접속 수
            .childOption(ChannelOption.SO_KEEPALIVE, true);  //패킷여부
            
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package com.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
	public void connect(String host, int port) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap boot = new Bootstrap();
		boot.group(group)
		.option(ChannelOption.TCP_NODELAY, true)
		.channel(NioSocketChannel.class)
		.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new TimeClientHandler());
			}
		});
		try {
			ChannelFuture future = boot.connect(host, port).sync();
			future.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		try {
			new TimeClient().connect("127.0.0.1", 8080);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

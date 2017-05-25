package com.server;


import com.server.unit.AbstractServerLifeCyle;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;

public class NettyServer extends AbstractServerLifeCyle {
	protected Bootstrap boot = new Bootstrap();
	protected ServerBootstrap serverBoot = new ServerBootstrap();
	protected ServerType serverType = ServerType.AS_SERVER;
	protected enum ServerType {
		AS_SERVER,
		AS_CLIENT
	}
	protected void bind(final String host, final int port) throws InterruptedException {
		ChannelFuture future = null;
		switch (serverType) {
			case AS_SERVER :
				future = serverBoot.bind(host, port).sync();
				break;
			case AS_CLIENT :
				future = boot.connect(host, port).sync();
				break;
		}
		future.channel().closeFuture().sync();
	}
}

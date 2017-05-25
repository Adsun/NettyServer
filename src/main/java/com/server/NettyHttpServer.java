package com.server;


import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;


public class NettyHttpServer extends NettyServer {
	private int port;
	public NettyHttpServer(int port) {
		this.port = port;
	}

	public void doStart() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		serverBoot.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch)
							throws Exception {
						ch.pipeline()
						.addLast("http-decoder", new HttpRequestDecoder())
					    .addLast("http-aggregator", new HttpObjectAggregator(65532))
						.addLast("http-eccoder", new HttpResponseEncoder())
						.addLast("http-chunked", new ChunkedWriteHandler())
						.addLast("http-handler", new HttpServerHandler());
					}
				});
		try {
			this.bind("127.0.0.1", port);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public void doStop() {
		System.exit(0);
	}
}

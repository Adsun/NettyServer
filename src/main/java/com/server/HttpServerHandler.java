package com.server;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

import com.server.http.connector.HttpNettyRequest;
import com.server.http.connector.HttpNettyResponse;
import com.server.http.connector.HttpRequestProcess;
import com.server.http.connector.HttpStaticResourceProcess;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4JLoggerFactory;

public class HttpServerHandler extends ChannelHandlerAdapter{
	private InternalLogger log = Log4JLoggerFactory.getInstance(HttpServerHandler.class);
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		log.error(cause);
		ctx.close();
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		try {
			if (FullHttpRequest.class.isInstance(msg)) {
				
			}
		} finally {
			log.debug("Release inputSteam message.");
			ReferenceCountUtil.release(msg);
		}
	}
}

package com.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter{
	private final ByteBuf firstMessage;
	public TimeClientHandler() {
		String hello = "hello";
		firstMessage = Unpooled.buffer(hello.getBytes().length);
		firstMessage.writeBytes(hello.getBytes());
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(firstMessage);
	}
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "UTF-8");
		System.out.println(body);
	}
	
}

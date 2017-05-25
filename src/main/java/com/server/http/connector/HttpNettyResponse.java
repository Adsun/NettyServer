package com.server.http.connector;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.Log4JLoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HttpNettyResponse implements ServletResponse{
	private InternalLogger log = Log4JLoggerFactory.getInstance(HttpNettyResponse.class);
	private ChannelHandlerContext ctx;
	public HttpNettyResponse(HttpNettyRequest request, ChannelHandlerContext ctx) {
		log.debug("Init HttpNettyResponse.");
		this.ctx = ctx;
	}
	
	public void write(Object msg) {
		ctx.write(msg);
	}
	
	public void flush() {
		ctx.flush();
	}

	public void writeAndFlush(Object msg) {
		ctx.writeAndFlush(msg);
	}

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLength(int len) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLengthLong(long len) {
		// TODO Auto-generated method stub
		
	}

	public void setContentType(String type) {
		// TODO Auto-generated method stub
		
	}

	public void setBufferSize(int size) {
		// TODO Auto-generated method stub
		
	}

	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub
		
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

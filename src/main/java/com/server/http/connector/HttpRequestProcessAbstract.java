package com.server.http.connector;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public abstract class HttpRequestProcessAbstract implements HttpRequestProcess{
	
	protected static HttpVersion version = HttpVersion.HTTP_1_1;
	protected static HttpResponseStatus status = HttpResponseStatus.OK;
	protected HttpHeaders headers = response.headers();
	
	private static FullHttpResponse response = new DefaultFullHttpResponse(version, status);
	
	protected enum ERROR_CODE {
		ERROR_404,
		ERROR_403
	}
	protected FullHttpResponse write(String content, String charSet) {
		ByteBuf buf = Unpooled.copiedBuffer(content, Charset.forName(charSet));
		response.content().writeBytes(buf);
		return response;
	}
	protected FullHttpResponse forword(String url) {
		return response;
	}
	protected String initUri(String uri) {
		try {
			uri = URLDecoder.decode(uri, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return uri;
	}
}

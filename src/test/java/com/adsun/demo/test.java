package com.adsun.demo;

import com.server.NettyHttpServer;

public class test {
	public static void main(String[] args) {
		NettyHttpServer server = new NettyHttpServer(8080);
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

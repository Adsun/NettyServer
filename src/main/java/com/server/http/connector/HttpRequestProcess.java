package com.server.http.connector;


public interface HttpRequestProcess {
	void requestProcess(HttpNettyRequest req, HttpNettyResponse respon);
}

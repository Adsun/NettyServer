package com.server.container;

public interface ContainerContext extends Container{
	void addServletMapping(String uri, String name);
	void getLoader();
	void setLoader();
}

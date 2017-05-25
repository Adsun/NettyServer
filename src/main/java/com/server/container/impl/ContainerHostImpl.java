package com.server.container.impl;

import java.util.Map;

import com.server.container.Container;
import com.server.container.ContainerHost;

public class ContainerHostImpl implements ContainerHost {
	private Map<String, Container> childContainer;
	
	public void invoke() {
		
	}
	
	public void addChild(Container child) {
	}

	public void removeChild(Container child) {

	}

	public Container findChild(String name) {
		return null;
	}

	public Container[] findChildren() {
		return null;
	}

	

}

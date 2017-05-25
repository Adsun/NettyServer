package com.server.container;

public interface Container {
	
	void addChild(Container child);
	
	void removeChild(Container child);
	
	Container findChild(String name);
	
	Container[] findChildren();
}

package com.server.unit;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public abstract class AbstractServerLifeCyle implements ServerLifeCycle {
	
	private static final Logger log = Logger.getLogger(AbstractServerLifeCyle.class);
	
	public static final String STOPPED="STOPPED";
    public static final String FAILED="FAILED";
    public static final String STARTING="STARTING";
    public static final String STARTED="STARTED";
    public static final String STOPPING="STOPPING";
    public static final String RUNNING="RUNNING";
    
    private final Object _lock = new Object();
    private final int __FAILED = -1, __STOPPED = 0, __STARTING = 1, __STARTED = 2, __STOPPING = 3;
    private volatile int _state = __STOPPED;
    private List<Listener> listeners = new ArrayList<Listener>();
    
    public void doStart() {
    	
    }
    
    public void doStop() {
    	
    }
    
	public final void start() throws Exception {
		synchronized (_lock) {
			if (_state == __STOPPED || _state == __FAILED) {
				setStarting();
				doStart();
				setStarted();
			}
		}
	}
	public final void stop() throws Exception {
		synchronized (_lock) {
			setStopping();
			doStop();
			setStopped();
		}
	}
	
	private void setStarting() {
		_state = __STARTING;
		log.debug(this.getClass() + " is starting.");
		for (Listener listener : listeners) {
			listener.lifeCycleStarting(this);
		}
	}
	
	private void setStarted() {
		_state = __STARTED;
		log.debug(this.getClass() + " is started.");
		for (Listener listener : listeners) {
			listener.lifeCycleStarted(this);
		}
	}
	
	private void setStopping() {
		_state = __STOPPING;
		log.debug(this.getClass() + " is stopping.");
		for (Listener listener : listeners) {
			listener.lifeCycleStopping(this);
		}
	}
	
	private void setStopped() {
		_state = __STOPPED;
		log.debug(this.getClass() + " is stopped.");
		for (Listener listener : listeners) {
			listener.lifeCycleStopped(this);
		}
	}
	
	public boolean isRunning() {
		final int state = _state;
		return state == __STARTED || state == __STARTING;
	}
	
	public boolean isStarted() {
		return _state == __STARTED;
	}
	
	public boolean isStarting() {
		return _state == __STARTING;
	}
	
	public boolean isStopping() {
		return _state == __STOPPING;
	}
	
	public boolean isStopped() {
		return _state == __STOPPED;
	}
	
	public boolean isFailed() {
		return false;
	}
	
	public String getState() {
		switch (_state) {
			case  __STOPPED :
				return STOPPED;
			case  __STOPPING :
				return STOPPING;
			case  __STARTED :
				return STARTED;
			case  __STARTING :
				return STARTING;
			case  __FAILED :
				return FAILED;
		}
		return null;
		
	}
	public void addLifeCycleListener(Listener listener) {
		listeners.add(listener);
	}
	public void removeLifeCycleListener(Listener listener) {
		listeners.remove(listener);
	}
    
    public abstract class AbstractListener implements ServerLifeCycle.Listener {

		public void lifeCycleStarting(ServerLifeCycle event) {}

		public void lifeCycleStarted(ServerLifeCycle event) {}

		public void lifeCycleFailure(ServerLifeCycle event, Throwable cause) {}

		public void lifeCycleStopping(ServerLifeCycle event) {}

		public void lifeCycleStopped(ServerLifeCycle event) {}
    	
    }
}

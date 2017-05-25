package com.server;

import com.server.unit.AbstractServerLifeCyle;
import com.server.unit.ServerLifeCycle;

public class HandleServer extends AbstractServerLifeCyle{

	@Override
	public void doStart() {
		// TODO Auto-generated method stub
		super.doStart();
	}

	@Override
	public void doStop() {
		// TODO Auto-generated method stub
		super.doStop();
	}
	
	public class HandleServerListener extends AbstractServerLifeCyle.AbstractListener {

		@Override
		public void lifeCycleStarting(ServerLifeCycle event) {
			// TODO Auto-generated method stub
			super.lifeCycleStarting(event);
		}

		@Override
		public void lifeCycleStarted(ServerLifeCycle event) {
			// TODO Auto-generated method stub
			super.lifeCycleStarted(event);
		}

		@Override
		public void lifeCycleFailure(ServerLifeCycle event, Throwable cause) {
			// TODO Auto-generated method stub
			super.lifeCycleFailure(event, cause);
		}

		@Override
		public void lifeCycleStopping(ServerLifeCycle event) {
			// TODO Auto-generated method stub
			super.lifeCycleStopping(event);
		}

		@Override
		public void lifeCycleStopped(ServerLifeCycle event) {
			// TODO Auto-generated method stub
			super.lifeCycleStopped(event);
		}
		
	}
}

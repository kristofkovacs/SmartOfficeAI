public class AlarmTimerThread implements Runnable{

	private boolean stopped = false;
	
	private AgentInfo infopanel;
	
	public AlarmTimerThread(AgentInfo panel){
		this.infopanel = panel;
	}
	
	@Override
	public void run(){
		while(!stopped && !infopanel.isAlarmCounterReachedZero()){
			try{Thread.sleep(1000);}catch(Exception e){}
			infopanel.decreaseAlarmTimer();		
		}	
	}
	
	public void stopCounter(){
		stopped = true;
	}
}
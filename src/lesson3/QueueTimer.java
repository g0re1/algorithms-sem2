package lesson3;

import java.util.Timer;
import java.util.TimerTask;

public class QueueTimer extends Timer{
	private Queue queue;
	
	public QueueTimer(Queue queue){
		super();
		this.queue = queue;
	}
	
	public void dequeueAfterSomeTime(int time){
		schedule(new queueTimerTask(), time);
	}
	
	private class queueTimerTask extends TimerTask{
		
		public void run() {
			queue.dequeue();
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){}
			System.out.println( scheduledExecutionTime() );
		}
		
	}
}

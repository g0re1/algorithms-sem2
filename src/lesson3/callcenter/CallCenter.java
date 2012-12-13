package lesson3.callcenter;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson3.Queue;
import lesson3.RealyBlockingQueue;

public class CallCenter {
	private  Queue queue = new RealyBlockingQueue();
	ArrayList consArray = new ArrayList();
	
	public void open(){
		
		for(int i=0;i<3;i++){
			Thread thread = new Thread(new Consultant(i,queue) );
			thread.start();
			consArray.add(thread);
		}		
	}
	public void accept(Call call){
		queue.enqueue(call);
		
	//	if(call.getId() == -1){
		//	close();
	//	}
	}
	
	public void close(){
		Iterator it = consArray.iterator();
		for(it.first();!it.isDone();it.next() ){
			waitForTermination( (Thread) it.current() );
		}
	    consArray.clear();
	}
	
	private void waitForTermination(Thread thread) {
	    try {
	        thread.join();
	    } catch (InterruptedException e) {
	        // Ignoruj
	    }
	}
}

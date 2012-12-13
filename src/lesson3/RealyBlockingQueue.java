package lesson3;

import java.util.Timer;

import lesson2.LinkedList;
import lesson2.List;

public class RealyBlockingQueue implements Queue{
	private int max_size= 32;
	private List list;
	private Object _mutex = new Object();
	
	public static void main(String[] args) {	
		
		Queue queue = new RealyBlockingQueue();
		
		for(int i=0; i<40;i++){
			queue.enqueue(i);
			System.out.println(i);
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
	
	public RealyBlockingQueue(){
		list = new LinkedList();
	}
	
	public RealyBlockingQueue(List list,int max){
		this.list = list;
		max_size = max;
	}

	public Object dequeue() throws EmptyQueueException {
		Object el;
		synchronized(_mutex){
			while(isEmpty() ) waitForNotification();
			
			el = list.delete(list.get(0));
			_mutex.notifyAll();
		}
		return el;
	}

	public void enqueue(Object element) {
		synchronized(_mutex){
			if(size() == max_size){
				waitForNotification();
			}
			list.add(element);
			_mutex.notifyAll();
		}
	}
	
	private void waitForNotification(){
		try{
			_mutex.wait();
		}
		catch(InterruptedException e){}
	}
	
	public void clear() {
		synchronized(_mutex){
			list.clear();
			_mutex.notifyAll();
		}	
	}

	public boolean isEmpty() {
		synchronized(_mutex) {
			return list.isEmpty();
		}
	}

	public int size() {
		synchronized(_mutex){
			return list.size();
		}
	}

}

package lesson3;

import java.util.Timer;

import lesson2.LinkedList;
import lesson2.List;

public class BlockingListQueue implements Queue{
	private List list;
	private int maximum=32;
	private boolean freeSpace = true;
	
	public static void main(String[] args) {
		BlockingListQueue blockQueue = new BlockingListQueue();
		QueueTimer t = new QueueTimer(blockQueue);
		
		for(int i=0;i<40;i++){
			if(i>32){
				try {
				    Thread.sleep(1000);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}
			blockQueue.enqueue(i);
			System.out.println(i);
			System.out.println("size = "+blockQueue.size());
		}
			
		for(int i=0;i<10;i++){
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			t.dequeueAfterSomeTime(0);
		}
		
		while(!blockQueue.isEmpty()){
			System.out.println(blockQueue.dequeue() );
		}
		
		t.cancel();
	}

	public BlockingListQueue(List list,int max){
		maximum = max;
		this.list = list;
	}
	
	public BlockingListQueue(List list){
		this.list = list;

	}
	
	public BlockingListQueue(){
		list = new LinkedList();
	}
	
	public BlockingListQueue(int max){
		maximum = max;
		list = new LinkedList();
	}
	
	public Object dequeue() throws EmptyQueueException {
		Object el = null; 
		
		try{
			el = list.delete(list.get(0));
		}
		catch(IndexOutOfBoundsException e){ 
			while ( (list.size() < maximum) ){
				wait(1000);
			}
		}
		updateFreeSpace();
		return el;
	}
	
	private void wait(int period){
		try {
		    Thread.sleep(period);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

	public void enqueue(Object element) {
		if (!freeSpace) wait(1000);
		else{
			list.add(element);
			updateFreeSpace();
		}
	}
	
	private void updateFreeSpace(){
		if(size() == maximum) freeSpace = false;
		else{freeSpace = true;}
	}
	
	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}
}

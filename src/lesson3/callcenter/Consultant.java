package lesson3.callcenter;

import lesson3.Queue;

public class Consultant implements Runnable{
	private int id;
	private Queue queue;
	
	public Consultant(int id,Queue queue){
		this.queue = queue;
		this.id = id;
		System.out.println("Konsultant "+id+" jest na miejscu");
	}
	
	public void run() {
		
		while(true){
			Call call = (Call)queue.dequeue();
			System.out.println("Konstultant : "+id);
			call.realize();
			}

	}
}



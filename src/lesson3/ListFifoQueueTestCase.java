package lesson3;

import lesson2.LinkedList;

public class ListFifoQueueTestCase extends AbstractFifoQueueTestCase {
	Queue queue;
	
	protected Queue createFifoQueue() {
		return new ListFifoQueue(new LinkedList());
	}
	
	public void testListFiQueue(){
		queue = createFifoQueue();
	}

}

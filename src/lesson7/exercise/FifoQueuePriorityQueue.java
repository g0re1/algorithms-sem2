package lesson7.exercise;

import java.util.Random;

import lesson3.EmptyQueueException;
import lesson3.ListFifoQueue;
import lesson3.Queue;
import lesson4.ListStack;
import lesson4.Stack;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class FifoQueuePriorityQueue implements Queue {
	private Comparator comparator;
	private Queue queue;
	
	public FifoQueuePriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		queue = new ListFifoQueue();
	}
	
	public static void main(String[] args){
		Queue fifoQueue = new FifoQueuePriorityQueue(NaturalComparator.INSTANCE);
		Random random = new Random();
		for(int i=0;i<10;i++){
			fifoQueue.enqueue(new Integer(i));
			//System.out.println(i);
		}
		while(!fifoQueue.isEmpty()){
			System.out.println( fifoQueue.dequeue() );
		}
	}
	public void clear() {
		queue.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException();
		//if(size() == 1) return queue.dequeue();
		return getLargest();
	}
	
	private Object getLargest(){
		Stack stack = new ListStack();
		Object largest = queue.dequeue();
		stack.push(largest);
		
		while(!queue.isEmpty()){
			stack.push(queue.dequeue());
			if ( comparator.compare(stack.peek(), largest) > 0 )largest = stack.peek();
		}
		
		while(!stack.isEmpty()){
			if(stack.peek() == largest){
				stack.pop();
				break;
			}
			queue.enqueue(stack.pop());
		}
		
		while(!stack.isEmpty()){
			queue.enqueue(stack.pop());
		}
		
		return largest;

	}
	public void enqueue(Object element) {
		queue.enqueue(element);
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	public int size() {
		return queue.size();
	}
}
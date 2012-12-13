package lesson7.exercise;

import java.util.Random;

import lesson3.EmptyQueueException;
import lesson3.ListFifoQueue;
import lesson3.Queue;
import lesson4.ListStack;
import lesson4.Stack;
import lesson5.Comparator;
import lesson5.NaturalComparator;
import lesson7.PriorityQueue.HeapPriorityQueue;

public class StackPriorityQueue implements Queue {
	private Comparator comparator;
	private Stack stack;
	
	public StackPriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		stack = new ListStack();
	}
	
	public static void main(String[] args){
		Queue stackQueue = new StackPriorityQueue(NaturalComparator.INSTANCE);
		Random random = new Random();
		for(int i=0;i<10;i++){
			stackQueue.enqueue(new Integer(random.nextInt(10)));
			//System.out.println(i);
		}
		
		while(!stackQueue.isEmpty()){
			System.out.println( stackQueue.dequeue() );
		}

	}
	public void clear() {
		stack.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if ( stack.isEmpty() ) throw new EmptyQueueException();
		if ( size() == 1)return stack.pop();
		return getLargest();
	}
	
	private Object getLargest(){
		Stack newStack = new ListStack();
		Object largest;
		newStack.push(largest = stack.pop() );

		while(!stack.isEmpty()){
			newStack.push( stack.pop() );
			if(comparator.compare(newStack.peek(), largest) > 0 ) largest=newStack.peek();
		}
		stack = newStack;
		Stack secNewStack = new ListStack();
		while(!stack.isEmpty()){
			secNewStack.push(stack.dequeue());
			if (secNewStack.peek() == largest){
				secNewStack.pop();
				break;
			}
		}
		while(!secNewStack.isEmpty()){
			stack.push(secNewStack.dequeue() );
		}

		return largest;
	}

	public void enqueue(Object element) {
		stack.enqueue(element);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}

}

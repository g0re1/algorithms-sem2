package lesson7.PriorityQueue;

import java.util.Random;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class UnsortedListPriorityQueue implements Queue {
	private Comparator comparator;
	private List list;
	
	public UnsortedListPriorityQueue(Comparator comparator) {
		assert comparator != null : "Comparator cannot be NULL";
		this.comparator = comparator;
		list = new ArrayList();
	}

	public static void main(String[] args){
		Queue priorityQueue = new UnsortedListPriorityQueue(NaturalComparator.INSTANCE);
		Random r = new Random();
		for(int i=0;i<10;i++){
			priorityQueue.enqueue(new Integer(r.nextInt(10)) );
			//System.out.println(i);
		}
		
		while(!priorityQueue.isEmpty()){
			System.out.println(priorityQueue.dequeue());
		}
	}
	
	public void clear() {
		list.clear();
	}
	public Object dequeue() throws EmptyQueueException {
		if ( list.isEmpty() ) throw new EmptyQueueException();	

		return list.delete(list.get(getIndexOfLargestElement() ));
	}
	
	private int getIndexOfLargestElement(){
		int result =0;
		
		for(int i=0;i<list.size();i++){
			if ( comparator.compare(list.get(i), list.get(result) ) > 0) result = i;
		}
		
		return result;
	}

	public void enqueue(Object element) {
		list.add(element);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}
}

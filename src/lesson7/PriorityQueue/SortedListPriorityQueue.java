package lesson7.PriorityQueue;

import java.util.Random;

import lesson2.ArrayList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class SortedListPriorityQueue implements Queue {
	private Comparator comparator;
	private List list;
	
	public SortedListPriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		list = new ArrayList();
	}
	
	public static void main(String[] args){
		Queue prioQueue = new SortedListPriorityQueue(NaturalComparator.INSTANCE);
	/*	Random random = new Random();
		for(int i=0;i<10;i++){
			priorityQueue.enqueue(new Integer(random.nextInt(10)) );
			//System.out.println(i);
		}*/
		
		final String VALUE_A = "A";
		final String VALUE_B = "B";
		final String VALUE_C = "C";
		final String VALUE_D = "D";
		final String VALUE_E = "E";
		
		prioQueue.enqueue(VALUE_A);
		prioQueue.enqueue(VALUE_B);
		prioQueue.enqueue(VALUE_C);
		
		prioQueue.dequeue();
		prioQueue.dequeue();
		
		prioQueue.enqueue(VALUE_E);
		prioQueue.enqueue(VALUE_D);

		
		while(!prioQueue.isEmpty()){
			System.out.println(prioQueue.dequeue());
		}
	}
	
	public void clear() {
		list.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if (list.isEmpty()) throw new EmptyQueueException();
		Object del = list.delete(list.get(list.size()-1));
		//System.out.println(del.toString());
		return del;
	}

	public void enqueue(Object element) {
		int largest = getIndexOfLargestElement();
		if(list.isEmpty())list.add(element) ;
		else if( ((comparator.compare(list.get(largest), element) > 0) )) list.insert(largest,element);
			else list.insert(largest+1, element);
		}
	
	private int getIndexOfLargestElement(){
		int result =0;
		
		for(int i=0;i<list.size();i++){
			if ( comparator.compare(list.get(i), list.get(result) ) > 0) result = i;
		}
				
		return result;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

}

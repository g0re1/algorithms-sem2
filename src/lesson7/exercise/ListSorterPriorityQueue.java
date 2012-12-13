package lesson7.exercise;

import lesson2.ArrayList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;
import lesson6.quicksort.QuickListSorter;

public class ListSorterPriorityQueue implements Queue,ListSorter {
	private Comparator comparator;
	private List list;
	
	public ListSorterPriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		list = new ArrayList();
	}
	
	public static void main (String[] args){
		Queue queue = new ListSorterPriorityQueue(NaturalComparator.INSTANCE);
		for(int i=0;i<10;i++){
			queue.enqueue(new Integer(i));
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}

	public void clear() {
		list.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if(list.isEmpty()) throw new EmptyQueueException();
		return list.delete(list.get(list.size()-1));
	}

	public void enqueue(Object element) {
		list.add(element);
		this.Sort(list);
	}

	public boolean isEmpty() {
		return  list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public List Sort(List list) {
		QuickListSorter quick = new QuickListSorter(comparator);
		list = quick.Sort(list);
		
		return list;
	}

}

package lesson7.exercise;

import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.ReverseComparator;

public class ReverseListSorterPriorityQueue extends ListSorterPriorityQueue {

	public ReverseListSorterPriorityQueue(Comparator comparator) {
		super(new ReverseComparator(comparator));

	}

}

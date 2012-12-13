package lesson7.PriorityQueue;

import lesson3.Queue;
import lesson5.Comparator;

public class HeapPriorityQueueTest extends AbstractPriorityQueueTest{

	protected Queue createQueue(Comparator comparator) {
		return new HeapPriorityQueue(comparator);
	}
	

}

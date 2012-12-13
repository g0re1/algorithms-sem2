package lesson7.PriorityQueue;

import lesson3.Queue;
import lesson5.Comparator;

public class UnsortedListPriorityQueueTest extends AbstractPriorityQueueTest {

	protected Queue createQueue(Comparator comparator) {
		return new UnsortedListPriorityQueue(comparator);
	}

}

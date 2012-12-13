package lesson7.exercise;

import lesson3.Queue;
import lesson5.Comparator;
import lesson7.PriorityQueue.AbstractPriorityQueueTest;

public class FifoQueuePriorityQueueTest extends AbstractPriorityQueueTest {

	protected Queue createQueue(Comparator comparator) {
		return new FifoQueuePriorityQueue(comparator);
	}

}

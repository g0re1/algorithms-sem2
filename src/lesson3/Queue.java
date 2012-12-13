package lesson3;

public interface Queue {
		public void enqueue(Object element);
		public Object dequeue() throws EmptyQueueException;
		public int size();
		public boolean isEmpty();
		public void clear();
}

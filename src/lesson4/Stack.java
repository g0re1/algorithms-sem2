package lesson4;

import lesson3.Queue;

public interface Stack extends Queue {
	public void push(Object element);
	public Object pop() throws EmptyStackException;
	public int size();
	public Object peek() throws EmptyStackException;
	public boolean isEmpty();
	public void clear();
}

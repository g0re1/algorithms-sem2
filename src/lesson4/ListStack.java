package lesson4;
import lesson2.ArrayList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.ListFifoQueue;
import lesson3.Queue;

public class ListStack implements Stack{
	private List list;
	
	public static void main(String[] args){
		Stack stack = new ListStack();
		
		Queue queue = new ListFifoQueue();
		
		for(int i=0;i<10;i++){
			queue.enqueue(new Integer(i));
		}
		int i=0;
		while(!queue.isEmpty()){
			i++;
			Object current = queue.dequeue();
			stack.push(current);
			if (i==8) {
				stack.pop();
				break;
			}
		}
		while(!stack.isEmpty()){
			queue.enqueue(stack.pop());
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
	
	public ListStack(){
		list = new ArrayList();
	}
	
	public ListStack(List list){
		this.list = list ;
	}

	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Object peek() throws EmptyStackException {
		if(isEmpty() ) throw new EmptyStackException(); 
		 	
		return list.get(0);

	}
	public Object pop() throws EmptyStackException {
		if(isEmpty() ) throw new EmptyStackException(); 
		
		return list.delete(list.get( 0 ) );
	}

	public void push(Object element) {
		assert element != null : "Element nie moze byc nullem";
		list.insert(0, element);
	}

	public int size() {
		return list.size();
	}

	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException() ;
	
		return pop();

	}

	public void enqueue(Object element) {
		list.add(element);
	}

}

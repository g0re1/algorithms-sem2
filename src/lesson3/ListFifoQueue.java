package lesson3;

import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;

public class ListFifoQueue implements Queue {

	private List list;
		
	public static void main(String[] args){
		Queue queue = new ListFifoQueue();
		
		for(int i=0;i<10;i++){
			queue.enqueue(new Integer(i));
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		for(int i=0;i<10;i++){
			queue.enqueue(new Integer(i));
		}
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
			
	}
	
	public ListFifoQueue(List list){
		assert list != null : "Lista nie może być pusta";
		this.list = list;	
	}
	
	public ListFifoQueue(){
		list = new ArrayList();
	}
	
	public String toString(){
		String s= "[ ";
		List list = new LinkedList();
		
		while(!isEmpty()){
			Object obj = dequeue();
			s +=  obj.toString() +", ";
			list.add(obj);
		}
		s+=" ]";
		this.list = list;
		
		return s;
	}
	
	public void clear() {
		list.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if (isEmpty())throw new EmptyQueueException();
		Object el = list.delete(list.get(0));
		return el;
	}

	public void enqueue(Object element) {
		assert element != null :"element cannot be null";
		list.add(element);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

}

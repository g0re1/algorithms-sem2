package lesson7.PriorityQueue;

import java.util.Random;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class HeapPriorityQueue implements Queue {
	private Comparator comparator;
	private List list;

	public HeapPriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		list = new ArrayList();
	}
	public static void main(String[] args){
		Queue heapQueue = new HeapPriorityQueue(NaturalComparator.INSTANCE);
		Random random = new Random();
		for(int i=0;i<10;i++){
			heapQueue.enqueue(new Integer(random.nextInt(10) ));
			//System.out.println(i);
		}
		
		while(!heapQueue.isEmpty()){
			System.out.println( heapQueue.dequeue() );
		}

	}
	public void clear() {
		list.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if (list.isEmpty()) throw new EmptyQueueException();
		
		swap(0,list.size()-1);
		Object el = list.delete( list.get(list.size()-1) );
		if (list.size() > 0)heapDescent();
		return el;
	}
	
	private void showList(){
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println("l -"+it.current());
			it.next();
		}
		System.out.println("---koniec---");
	}
	
	private void heapDescent(){ 
		
		int x = 0 ;
		Object father = list.get(x);
		Object son1;
		Object son2;
		boolean left = true;
		boolean right = true;
		
		while( left || right   ){
			x = list.indexOf(father);
			try{
			//	System.out.println("x = "+x);
				son2 = list.get(2*x+2);
			}
			catch(IndexOutOfBoundsException e){right = false;son2=null;}
			try{
				son1 = list.get(2*x+1); 
				}
			catch(IndexOutOfBoundsException e){left=false;son1=null;}	
			
			if( (son1!=null) && (son2!=null) ){
				 if ((comparator.compare(son1,son2)> 0)){
					 swap(list.indexOf(son1),list.indexOf(father));
				 }
				 else{
					 swap(list.indexOf(son2),list.indexOf(father));
				 }
			}
			else{
				if(son1!=null){
					 if ((left = comparator.compare(son1,father)> 0)){
						 swap(list.indexOf(son1),list.indexOf(father));
					 }
				}
				if (son2!=null){
					if ((right = comparator.compare(son2,father)> 0)){
						 swap(list.indexOf(son2),list.indexOf(father));
					}
				}
			}
		} 
	}

	public void enqueue(Object element) {
		list.add(element);
		heapAscent();
	}
	
	private void heapAscent(){
		int x = list.size()-1;
		Object son = list.get(x);
		Object father = list.get((x-1)/2);
		
		while ( (comparator.compare(son,father)> 0))  {
			swap(list.indexOf(son),list.indexOf(father));
			x = list.indexOf(son);
			father = list.get((x-1)/2);	
		}
		//this.showList();
	}

	private void swap(int left, int right){
		if(left==right)return;
		
		Object obj = list.get(left);
		list.set(left, list.get(right));
		list.set(right, obj);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

}

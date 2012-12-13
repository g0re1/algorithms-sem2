package lesson7.exercise;

import java.util.Random;

import lesson2.ArrayList;
import lesson2.List;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class RecursiveHeapPriorityQueue implements Queue {
	private Comparator comparator;
	private List list;
	
	public RecursiveHeapPriorityQueue(Comparator comparator) {
		this.comparator = comparator;
		list = new ArrayList();
	}
	
	public static void main(String[] args){
		RecursiveHeapPriorityQueue queue = new RecursiveHeapPriorityQueue(NaturalComparator.INSTANCE);
		Random random = new Random();
		for(int i=0;i<10;i++){
			queue.enqueue(new Integer(random.nextInt(10)));
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}
	public void show(){
		while(!list.isEmpty()){
			System.out.println( list.delete(list.get(0)) );
		}
	}

	public void clear() {
		list.clear();
	}

	public Object dequeue() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException();
		if(size() == 1) return list.delete(list.get(0));
		swap(0,list.size()-1);
		Object el = list.delete(list.get( list.size()-1 ));
		sink(0);
		return el;
		
	}
	
	private void sink(int x){

		int left = 2*x+1; 
		int right= 2*x+2;
		
		int greatest = x;
		
		if(left<=list.size()-1) greatest = left;
		
		if(right<=list.size()-1 ){
			if (comparator.compare(list.get(left), list.get(right) ) < 0) greatest = right;
		}
		
		if(comparator.compare(list.get(greatest), list.get(x)) > 0 ){
			swap(greatest,x);
			sink(greatest);
		}
		

	}

	public void enqueue(Object element) {
		list.add(element);
		swim(list.size()-1);
	}
	
	private void swim(int x){
		if(x==0) return;
		int fatherIndex = (x-1)/2;
		
		if(comparator.compare(list.get(x), list.get(fatherIndex)) > 0) swap(fatherIndex,x);
		swim(fatherIndex);
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

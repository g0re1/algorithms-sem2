package lesson1.exercise;

import lesson1.ArrayIterator;
import lesson1.Iterator;

public class EmptyIterator extends ArrayIterator {
	public static void main(String[] args){
		String[] ARRAY =  {"A","B","C"};
		Iterator ite = new EmptyIterator(ARRAY);
		ite.first();
		while(!ite.isDone()){
			System.out.println(ite.current());
			ite.next();
		}
		
	}
	public EmptyIterator(Object[] array) {
		super(array);
	}
	
	public boolean isDone(){
		return true;
	}

}

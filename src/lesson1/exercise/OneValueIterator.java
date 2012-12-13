package lesson1.exercise;

import lesson1.ArrayIterator;
import lesson1.Iterator;

public class OneValueIterator extends ArrayIterator{
	
	public static void main(String[] args){
		String[] ARRAY =  {"A","B","C"};
		Iterator ite = new OneValueIterator(ARRAY);
		ite.first();
		
		while(!ite.isDone()){
			System.out.println(ite.current());
			ite.next();
		}

		System.out.println( ite.isDone() );
	}
	
	public OneValueIterator(Object[] array){
		super(array,1,1);	
	}
	
	public void last(){
		
	}


	

}

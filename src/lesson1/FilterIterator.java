package lesson1;

import lesson1.exercise.AndPredicate;
import lesson1.exercise.ByNPredicate;

public class FilterIterator implements Iterator{
	private Iterator it;
	private Predicate pre;
	
	public static void main(String[] args){
		long teraz = System.currentTimeMillis();
		
		final Object[] ARRAY = {"A","B","C","D","E","F"};
		Iterator it = new ArrayIterator(ARRAY);
		
		Predicate firstPre = new ByNPredicate(new ArrayIterator(ARRAY),2);
		Predicate secondPre = new ByNPredicate(new ArrayIterator(ARRAY),3);
		FilterIterator filt = new FilterIterator( it, new AndPredicate(firstPre,secondPre));
		
		filt.first();
		//System.out.println(!filt.isDone());
		
		while(!filt.isDone()){
		System.out.println( filt.current() );
		filt.next();
		}
	
		long pozniej = System.currentTimeMillis();
		double czas = pozniej - teraz;
		czas/=1000;
		
		System.out.println(czas+" sek");
		
	}
	
	public FilterIterator(Iterator iterator,Predicate predicate){
		assert iterator != null : "nie określono iteratora";
		assert predicate != null : "nie określono predykatora";

		pre = predicate;
		it = iterator ;
	}

	public Object current() throws IteratorOutOfBoundsException {
		return it.current();
	}
	
	private void filterForward(){
		while( !it.isDone() && !pre.evaluate(it.current() ) ){
			it.next();
		}
	}
	
	private void filterBackward(){
		while(!it.isDone() && !pre.evaluate(it.current() ) ){
			it.previous();
		}
	}

	public void first() {
		it.first();
		filterForward();
	}

	public boolean isDone() {
		return it.isDone();
	}


	public void last() {
		it.last();
		filterBackward();
		
	}

	public void next() {
		it.next();
		filterForward();	
	}
	
	public void previous() {
		it.previous();
		filterBackward();	
	}
}

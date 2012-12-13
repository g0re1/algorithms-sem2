package lesson1.exercise;

import lesson1.Iterator;
import lesson1.Predicate;

public class AndPredicate implements Predicate{
	private Iterator itFirst; // default Iterator first 
	private Iterator itSecond; // default Iterator second
	private boolean result;
	private Predicate preFirst, preSecond;
	
	public AndPredicate(Predicate preF, Predicate preS){
		preFirst = preF;
		preSecond = preS;
	}
	
	public boolean evaluate(Object object) {
		result = false;
		
		boolean first = preFirst.evaluate(object);
		boolean second = preSecond.evaluate(object);
		
		result = ( first && second );

		return result;
	}

}

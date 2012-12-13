package lesson1.exercise;

import junit.framework.TestCase;
import lesson1.ArrayIterator;
import lesson1.FilterIterator;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;
import lesson1.Predicate;

public class AndPredicateTest extends TestCase{
	private static final Object[] ARRAY = {"A","B","C","D","E","F"};
	
	public void testForwardFilterIteration(){
		Iterator it = new ArrayIterator(ARRAY);
		
		Predicate firstPre = new ByNPredicate(new ArrayIterator(ARRAY),2);
		Predicate secondPre = new ByNPredicate(new ArrayIterator(ARRAY),3);
		FilterIterator filt = new FilterIterator( it,new AndPredicate(firstPre,secondPre) );
		
		filt.first();
		assertFalse(filt.isDone());
		
		assertSame(filt.current(),ARRAY[5]);
		
		filt.next();
		assertTrue(filt.isDone());
		
		try{
			filt.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){}
		
		
	}
}

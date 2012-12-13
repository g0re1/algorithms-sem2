package lesson1.exercise;

import junit.framework.TestCase;
import lesson1.ArrayIterator;
import lesson1.FilterIterator;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public class ByNFilterIteratorTest extends TestCase {
	private static final Object[] ARRAY = {"A","B","C","D","E","F"};
	
	public void testForwardByNFilterIteration(){
		ArrayIterator defIt = new ArrayIterator(ARRAY); // default iterator
		ArrayIterator toFiltIt = new ArrayIterator(ARRAY); // to filter
		Iterator filtIt = new FilterIterator(toFiltIt,new ByNPredicate(defIt,2));
		
		filtIt.first();
		assertFalse( filtIt.isDone() );
		assertSame(filtIt.current(),ARRAY[1]);
		
		filtIt.next();
		assertFalse( filtIt.isDone() );
		assertSame(filtIt.current(),ARRAY[3]);
		
		filtIt.next();
		assertFalse( filtIt.isDone() );
		assertSame(filtIt.current(),ARRAY[5]);
		
		filtIt.next();
		assertTrue(filtIt.isDone());
		
		try{
			filtIt.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			
		}
		assertTrue(defIt.isDone());
		assertTrue(toFiltIt.isDone());
	
	}
}

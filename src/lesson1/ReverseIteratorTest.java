package lesson1;

import junit.framework.TestCase;

public class ReverseIteratorTest extends TestCase {
	Object[] ARRAY = {"A","B","C"};
	ArrayIterator iterator = new ArrayIterator(ARRAY);
	
	public void testReverseIteration(){
		ReverseIterator it = new ReverseIterator(iterator);
		
		it.first();		
		assertEquals(ARRAY[2],it.current());
		
		it.next();
		assertEquals(ARRAY[1],it.current());
		
		it.next();
		assertEquals(ARRAY[0],it.current());
		
		it.next();
		assertTrue(it.isDone());
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
		}
	}
}
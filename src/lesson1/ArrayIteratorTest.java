package lesson1;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase{
	
	public void testIterationRespectsBounds(){
		Object[] array = new Object[] {"A","B","C","D","E","F"};
		ArrayIterator iterator = new ArrayIterator (array,1,3);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current() );
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current() );
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[3], iterator.current() );
		
		iterator.next();
		assertTrue(iterator.isDone());
		try{
			iterator.current();
			fail();
		}
		catch (IteratorOutOfBoundsException e){
			
		}
	}
	
	public void testBackwardsIteration(){
		Object[] array = new Object[] {"A", "B", "C"};
		ArrayIterator iterator = new ArrayIterator(array);
			
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current() );
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current() );
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[0], iterator.current() );
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try{
			iterator.current();
			fail();
		}
		catch (IteratorOutOfBoundsException e){
			
		}
		
	}

}
	
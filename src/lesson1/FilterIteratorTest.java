package lesson1;

import junit.framework.TestCase;

public class FilterIteratorTest extends TestCase {
	private static final Object[] ARRAY = {"A","B","C"};

	private static final class DummyPredicate implements Predicate{
		private final Iterator _iterator;
		private final boolean _result;
		
		public DummyPredicate(boolean result, Iterator iterator){
		_result = result;
		_iterator = iterator;
		_iterator.first();
		}
		
		public boolean evaluate(Object object){
			assertSame(_iterator.current(), object);
			_iterator.next();
			return _result;
		}
	}
	
	public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {
		
		Iterator expectedIterator = new ArrayIterator(ARRAY);
		Iterator underlyinglterator = new ArrayIterator(ARRAY);
		Iterator iterator = new FilterIterator(underlyinglterator, new DummyPredicate (true, expectedIterator) );

		iterator. first();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[0],iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[1],iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[2],iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone() );
		
		try{
			iterator.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyinglterator.isDone());
	}
	
	public void testForwardsIterationIncludesItemsWhenPredicateReturnsFalse() {
		
		Iterator expectedIterator = new ArrayIterator(ARRAY);
		Iterator underlyinglterator = new ArrayIterator(ARRAY);
		Iterator iterator = new FilterIterator(underlyinglterator, new DummyPredicate (false, expectedIterator) );
		
		iterator.first();
		assertTrue(iterator.isDone());
		
		try{
			iterator.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyinglterator.isDone());
	}
	
	public void testBackwardssIterationlncludesItemsWhenPredicateReturnsTrue() {
		Iterator expectedIterator = new ReverseIterator( new ArrayIterator(ARRAY) );
		Iterator underlyinglterator = new ArrayIterator(ARRAY);
		Iterator iterator = new FilterIterator(underlyinglterator, new DummyPredicate (true, expectedIterator) );
		
		iterator.last();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[2],iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[1],iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone() );
		assertSame(ARRAY[0],iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone() );
		
		try{
			iterator.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyinglterator.isDone());	
	}
	public void testBackwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
		Iterator expectedIterator = new ReverseIterator( new ArrayIterator(ARRAY) );
		Iterator underlyinglterator = new ArrayIterator(ARRAY) ;
		Iterator iterator = new FilterIterator(underlyinglterator, new DummyPredicate (false, expectedIterator) );
		
		iterator.last();
		assertTrue( iterator.isDone() ) ;
		
		try{
			iterator.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyinglterator.isDone());
	}
}


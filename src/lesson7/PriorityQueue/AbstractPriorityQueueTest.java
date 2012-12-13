package lesson7.PriorityQueue;

import junit.framework.TestCase;
import lesson3.EmptyQueueException;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public abstract class AbstractPriorityQueueTest extends TestCase {
	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private static final String VALUE_E = "E";
	
	private Queue queue;
	
	protected void setUp() throws Exception{
		super.setUp();
		queue = createQueue(NaturalComparator.INSTANCE);
	}
	
	protected void tearDown() throws Exception{
		queue = null;
		super.tearDown();
	}
	
	protected abstract Queue createQueue(Comparator comparator);
	
	public void testEmptyQueueAccess(){
		assertTrue( queue.isEmpty() );
		try{
			queue.dequeue();
			fail();
		}
		catch(EmptyQueueException e){}
	}
	
	public void testDoesPriorityQueueReturnsGreatestValue(){
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		queue.enqueue(VALUE_C);
		
		assertFalse(queue.isEmpty());
		assertEquals(3,queue.size());
		
		assertEquals(queue.dequeue(),VALUE_C);
		assertFalse(queue.isEmpty());
		assertEquals(2,queue.size());
		
		assertEquals(queue.dequeue(),VALUE_B);
		assertFalse(queue.isEmpty());
		assertEquals(1,queue.size());
		
		queue.enqueue(VALUE_E);
		queue.enqueue(VALUE_D);
		
		assertEquals(queue.dequeue(),VALUE_E);
		assertFalse(queue.isEmpty());
		assertEquals(2,queue.size());
		
		assertEquals(queue.dequeue(),VALUE_D);
		assertFalse(queue.isEmpty());
		assertEquals(1,queue.size());
		
		assertEquals(queue.dequeue(),VALUE_A);
		assertTrue(queue.isEmpty());
	}
	public void testClearRemovesAllElements(){
		assertTrue(queue.isEmpty());
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		assertFalse(queue.isEmpty() );
		
		queue.clear();
		assertTrue(queue.isEmpty());
	}

}

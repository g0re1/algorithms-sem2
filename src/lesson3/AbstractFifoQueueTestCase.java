package lesson3;

import junit.framework.TestCase;

public abstract class AbstractFifoQueueTestCase extends TestCase {
	private static final Object VALUE_A = "A";
	private static final Object VALUE_B = "B";
	private static final Object VALUE_C = "C";
	
	private Queue queue;
	
	protected void setUp() throws Exception{
		super.setUp();
		
		queue = createFifoQueue();
	}
	protected abstract Queue createFifoQueue();
	
	public void testEmptyQueueExceptionAndIsEmpty(){
		assertTrue( queue.isEmpty() );
		
		try{
			queue.dequeue();
			fail();
		}
		catch(EmptyQueueException e) { }
	}
	
	public void testEnqueuAddsElementAndSizeGrows(){
		assertSame(0,queue.size());
		
		queue.enqueue(VALUE_A);
		assertSame(1,queue.size());
		assertFalse(queue.isEmpty());
		
		queue.enqueue(VALUE_B);
		assertSame(2,queue.size());
		assertFalse(queue.isEmpty());
		
		assertEquals(VALUE_A, queue.dequeue() );
		assertSame(1,queue.size());
		assertFalse(queue.isEmpty());
		
		assertEquals(VALUE_B, queue.dequeue() );
		assertSame(0,queue.size());
		assertTrue( queue.isEmpty() );
		
		try{
			queue.dequeue();
			fail();
		}
		catch(EmptyQueueException e) {}		
	}
	
	public void testClearEraseAllQueue(){
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		queue.enqueue(VALUE_A);
		assertSame(3,queue.size());
		
		queue.clear();
		assertTrue( queue.isEmpty() );	
	}
	
	public void testDequeueWorkAndReturnsCorrectElement(){
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		queue.enqueue(VALUE_C);
		
		assertEquals(VALUE_A,queue.dequeue());
		assertEquals(VALUE_B,queue.dequeue());
		assertEquals(VALUE_C,queue.dequeue());
		
		assertTrue(queue.isEmpty() );
		
		try{
			queue.dequeue();
			fail();
		}
		catch(EmptyQueueException e){}
	}
	
	
}

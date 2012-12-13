package lesson4;

import junit.framework.TestCase;

public abstract class AbstractStackTestCase extends TestCase {
	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";
	
	protected abstract Stack createStack();
	
	public void testDoesPushAddsElementsIncAndDecSizeAndIsEmptyWorks(){
		Stack stack = createStack();
		
		assertTrue(stack.isEmpty() );
		assertSame(0,stack.size());
		
		stack.push(VALUE_A);
		assertSame(1,stack.size());
		
		stack.push(VALUE_B);
		assertSame(2,stack.size() );
		
		stack.push(VALUE_C);
		assertSame(3,stack.size() );
		
		stack.clear();
		
		assertTrue(stack.isEmpty() );
		assertSame(0,stack.size());
	}
	
	public void testPopOutOfBounds(){
		Stack stack = createStack();
		
		try{
			stack.pop();
			fail();
		}
		catch(EmptyStackException e){}
		
		stack.push(VALUE_A);
		stack.push(VALUE_B);
		stack.push(VALUE_C);
		
		assertEquals(VALUE_C, stack.pop() );
		assertEquals(VALUE_B, stack.pop() );
		assertEquals(VALUE_A, stack.pop() );
		
		try{
			stack.pop();
			fail();
		}
		catch(EmptyStackException e){}
	}
	
	public void testPeekOutOfBounds(){
		Stack stack = createStack();
		
		try{
			stack.peek();
			fail();
		}
		catch(EmptyStackException e){}
		
		stack.push(VALUE_A);
		stack.push(VALUE_B);
		stack.push(VALUE_C);
		
		assertEquals(VALUE_C, stack.pop() );
		assertEquals(VALUE_B, stack.pop() );
		assertEquals(VALUE_A, stack.pop() );
		
		assertTrue(stack.isEmpty() );
		
		try{
			stack.peek();
			fail();
		}
		catch(EmptyStackException e){}
	}
}
package lesson11.set;

import junit.framework.TestCase;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;
import lesson1.ReverseIterator;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;

public abstract class AbstractSetTest  extends TestCase{
	
	private static final Object A = "a";
	private static final Object B = "b";
	private static final Object C = "c";
	private static final Object D = "d";
	private static final Object E = "e";
	private static final Object F = "f";
	
	private Set set;
	
	protected void setUp() throws Exception{
		set = createSet();
		
		set.add(A);
		set.add(B);
		set.add(C);
		set.add(D);
	}
	
	protected abstract Set createSet();

	public void testContains(){
		assertTrue(set.contains(A));
		assertTrue(set.contains(B));
		assertTrue(set.contains(C));
		assertTrue(set.contains(D));
	}
	public void testDoesntContains(){
		assertFalse(set.contains(E));
		assertFalse(set.contains(F));
	}
	public void testClear(){
		assertFalse(set.isEmpty());
		assertFalse(set.size() == 0);
		
		set.clear();
		
		assertTrue(set.isEmpty());
		assertTrue(set.size() == 0);
	}
	public void testAddsSameObjectReturnFalseAndDosntIncSize(){
		int size = set.size();
		
		assertFalse(set.add(A));
		assertFalse(set.add(B));
		assertFalse(set.add(C));
		
		assertTrue(size == set.size());
	}
	public void testDelete(){
		assertTrue(set.size() == 4);
		
		assertTrue(set.delete(A));
		assertTrue(set.size() == 3);
		
		assertTrue(set.delete(B));
		assertTrue(set.delete(C));
		assertTrue(set.delete(D));
		
		assertFalse(set.delete(A));
		
		assertTrue(set.isEmpty());
		assertTrue(set.size() == 0);
	}
	
	public void testIteratorForwards(){
		checkIterator(set.iterator());
	}
	
	public void testIteratorBackwards(){
		checkIterator(new ReverseIterator (set.iterator()));
	}
	private void checkIterator(Iterator it){
		List list = new ArrayList();
		it.first();
		while(!it.isDone()){
			list.add(it.current());
			it.next();
		}
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){}
		
		assertSame(4,set.size());
		assertTrue(list.contains(A));
		assertTrue(list.contains(B));
		assertTrue(list.contains(C));
		assertTrue(list.contains(D));
	}
}

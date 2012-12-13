package lesson2;

import junit.framework.TestCase;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public  abstract class AbstractListTestCase extends TestCase {
	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";
	
	protected abstract List createList();
	
	public void testAddInsertBetweenElements(){
		
		List list = createList();
		assertEquals(0,list.size() );
		assertTrue(list.isEmpty()) ;
		
		list.add(VALUE_A);
		assertEquals(1,list.size() );
		assertFalse(list.isEmpty() );
		
		list.add(VALUE_B);
		assertEquals(2,list.size() );
		assertFalse(list.isEmpty() );
		
		list.insert(0,VALUE_C);
		assertEquals(3,list.size() );
		assertFalse(list.isEmpty() );
		
		assertSame(VALUE_C,list.get(0));
		assertSame(VALUE_A,list.get(1));
		assertSame(VALUE_B,list.get(2));
		
		try{
			list.insert(5,VALUE_A);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			
		}
	}
	
	public void testInserBeforeFirstElement(){
		List list = createList();
		
		list.insert(0,VALUE_A);
		list.insert(0,VALUE_B);
		
		assertSame(VALUE_B,list.get(0));
		assertSame(VALUE_A,list.get(1));
		assertEquals(2,list.size());
		assertFalse(list.isEmpty());
	}
	
	public void testInsertAfterLastElement(){
		List list = createList();
		
		list.insert(0,VALUE_A);
		list.insert(1,VALUE_B);

		assertSame(VALUE_A,list.get(0));
		assertSame(VALUE_B,list.get(1));
		assertEquals(2,list.size());
		assertFalse(list.isEmpty());
	}
	
	public void testInsertOutOfBounds(){
		List list = createList();

		try{
		list.insert(-1, VALUE_A);
		fail();
		}
		catch(IndexOutOfBoundsException e){
			// oczekiwane
		}
		
		try{
			list.insert(1, VALUE_A);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			// expected
		}	
	}
	
	public void testAdd(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3,list.size() );
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
	}
	
	public void testSet(){
		List list = createList();
			
		list.insert(0,VALUE_A);
		assertSame(VALUE_A, list.get(0));
		
		list.set(0,VALUE_B);
		assertSame(VALUE_B, list.get(0));
	}
	
	public void testGetOutOfBounds(){
		List list = createList();
		try{
			list.get(-1);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}
		
		try{
			list.get(0);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}	
		list.add(VALUE_A);
		try{
			list.get(1);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}
	}
	
	public void testSetOutOfBounds(){
		List list = createList();
		try{
			list.set(-1,VALUE_B);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}
		
		try{
			list.set(0,VALUE_B);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}	
		list.add(VALUE_A);
		
		try{
			list.set(1,VALUE_B);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}
	}
	
	public void testDoesDeleteGeneralyWorks(){
		List list = createList();
		
		list.add(VALUE_A);
		list.delete(0);
		assertTrue(list.isEmpty());
		
	}
	
	public void testDeleteOutOfBounds(){
		List list = createList();
		
		list.add(VALUE_A);
		try{
			list.delete(VALUE_B);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			//expected
		}
		
	}
	
	public void testDeleteRemovesElement(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertSame(3,list.size());
		
		list.delete(1);
		assertSame(VALUE_A,list.get(0) );
		assertSame(VALUE_C,list.get(1) );
		
		list.delete(0);
		assertSame(VALUE_C,list.get(0) );
		
		list.delete(0);
		
		assertTrue(list.isEmpty() );
		

	}
	
	public void testDeleteByValue(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		list.delete(VALUE_A);
		assertSame(VALUE_B,list.get(0));
		assertSame(VALUE_A,list.get(1));
	}
	
	public void testIteratorEmptyList(){
		List list = createList();
		
		Iterator it = list.iterator();
		assertTrue(it.isDone());
		
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			//expected
		}
	}
	public void testListIteratorForwards(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		Iterator it = list.iterator();
		it.first();	
		assertSame(it.current(),list.get(0) );
		
		it.next();
		assertSame(it.current(),list.get(1) );
		
		it.next();
		assertSame(it.current(),list.get(2) );
		
		it.next();
		assertTrue(it.isDone() );
		
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			//expected
		}
		
	}
	public void testListIteratorBackwards(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		Iterator it = list.iterator();
		it.last();	
		assertSame(it.current(),list.get(2) );
		
		it.previous();
		assertSame(it.current(),list.get(1) );
		
		it.previous();
		assertSame(it.current(),list.get(0) );
		
		it.previous();
		assertTrue(it.isDone() );
		
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){
			//expected
		}
	}
	
	public void testDoesContainsGeneralyWorks(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertTrue(list.contains(VALUE_A) );
		assertFalse(list.contains(VALUE_C) );
	}
	
	public void testDoesListClearGeneralyWorks(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertFalse(list.isEmpty() );
		
		list.clear();
		
		assertTrue(list.isEmpty());
	}
	
	public void testDoesIndexOfGetsFirstElementIndex(){
		List list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertEquals(0,list.indexOf(VALUE_A));
		list.delete(0);
		assertEquals(1,list.indexOf(VALUE_A));
		assertEquals(-1,list.indexOf(VALUE_C));
		
	}
	

	
}

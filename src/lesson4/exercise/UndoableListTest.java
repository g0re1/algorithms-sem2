package lesson4.exercise;

import lesson2.AbstractListTestCase;
import lesson2.ArrayList;
import lesson2.List;

public class UndoableListTest extends AbstractListTestCase {
	
	protected List createList() {
		return new UndoableList(new ArrayList() );
	}
	
	public void testUndoAdd(){
		UndoableList list = new UndoableList(new ArrayList() );
		assertTrue(list.isEmpty());
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		assertSame(3,list.size());
		
		assertTrue(list.canUndo() );
		list.undo();
		assertSame(2,list.size());
		
		assertTrue(list.canUndo() );
		list.undo();
		assertSame(1,list.size());
		
		assertTrue(list.canUndo() );
		list.undo();
		
		assertSame(0,list.size());
		assertTrue(list.isEmpty());
		
		assertFalse(list.canUndo() );
	}
	public void testUndoInsert(){
		UndoableList list = new UndoableList(new ArrayList() );
		assertFalse(list.canUndo() );
		
		list.insert(0, VALUE_A);
		assertSame(1, list.size() );
		assertTrue(list.canUndo() );
		
		list.undo();
		assertSame(0, list.size() );
		assertTrue(list.isEmpty() );
		assertFalse(list.canUndo() );
	
	}
	
	public void testUndoDeleteByValue(){
		UndoableList list = new UndoableList(new ArrayList() );
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertTrue(list.canUndo() );
		
		Object delObj = list.delete(VALUE_C);
		assertSame(2, list.size() );
		
		
		assertTrue( list.canUndo() );
		list.undo();
		
		assertSame(3, list.size() );
		assertEquals(delObj, list.get(2));
		
		list.canUndo() ;		
	}
	public void testDeleteByPosition(){
		UndoableList list = new UndoableList(new ArrayList() );
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertSame(3, list.size() );
		
		list.delete(0);
		list.delete(0);
		list.delete(0);
		
		assertSame(0, list.size() );	
		
		assertTrue( list.canUndo() );	
		list.undo();
		assertSame(1, list.size() );
		
		assertTrue( list.canUndo() );
		list.undo();
		assertSame(2, list.size() );
		
		assertTrue( list.canUndo() );
		list.undo();
		assertSame(3, list.size() );
		
		assertTrue(list.canUndo() );
	}
	public void testUndoSet(){
		UndoableList list = new UndoableList(new ArrayList() );
		
		list.add(VALUE_A);
		list.set(0, VALUE_B);
		
		list.canUndo();
		list.undo();
		assertSame(1, list.size()) ;
		
		list.canUndo();
		list.undo();
		assertSame(0, list.size()) ;
		
		assertFalse (list.canUndo() );
	}
	public void testUndoClear(){
		UndoableList list = new UndoableList(new ArrayList() );
		list.add(VALUE_A);
		
		list.clear();
		
		assertFalse(list.canUndo());
	}
	
	public void testMultipleUndo(){
		UndoableList list = new UndoableList(new ArrayList() );
	}
}

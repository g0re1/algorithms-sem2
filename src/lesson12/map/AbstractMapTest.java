package lesson12.map;

import junit.framework.TestCase;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;
import lesson1.ReverseIterator;
import lesson2.LinkedList;
import lesson2.List;

public abstract class AbstractMapTest extends TestCase {
	private DefaultEntry entry1 = new DefaultEntry("Jarek",5);
	private DefaultEntry entry2 = new DefaultEntry("Pawel",6);
	private DefaultEntry entry3 = new DefaultEntry("Stefan",7);
	private DefaultEntry entry4 = new DefaultEntry("Czarek",7);
	private DefaultEntry entry5 = new DefaultEntry("Jarek",1);
	
	private Map map;
	
	protected void setUp() throws Exception{
		map = this.createMap();
		map.set("Jarek", 5);
		map.set("Pawel", 6);
		map.set("Stefan", 7);
	}
	protected abstract Map createMap();
	
	public void testGetExistingKey(){
		assertEquals(map.get("Jarek"), entry1.getValue());
		assertEquals(map.get("Pawel"), entry2.getValue());
		assertEquals(map.get("Stefan"), entry3.getValue());
	}
	
	public void testGetNonExistingKey(){
		assertNull(map.get("Czarek"));
		assertNull(map.get("CzarekDuparek"));
	}
	
	public void testSetNewValue(){
		int size = map.size();
		map.set("Czarek", 7);
		assertSame(size+1,map.size());
		assertEquals(map.get("Czarek"),entry4.getValue());
	}
	
	public void testSetAcceptOnlyUniqueKeys(){
		int size = map.size();
		
		map.set("Jarek", 1);
		assertEquals(map.get("Jarek"),entry5.getValue() );
		assertSame(size,map.size());		
	}
	
	public void testSetTryNullKey(){
		map.set(null, 0);
	}
	
	public void testDeleteExistingKey(){
		int size = map.size();
		map.delete("Jarek");
		assertSame(size-1,map.size());
	}
	
	public void testDeleteNonExistingKey(){
		int size = map.size();
		map.delete("Bartlomiej");
		assertSame(size,map.size());
	}
	public void testContains(){
		assertTrue(map.contains("Jarek"));
		assertFalse(map.contains("Bartlomiej"));
	}
	public void testClearAndIsEmpty(){
		map.clear();
		assertSame(map.size(),0);
		assertTrue(map.isEmpty());
	}
	public void testIteratorForwards(){
		checkIterator(map.iterator());
	}
	
	public void testIteratorBackward(){
		checkIterator(new ReverseIterator( map.iterator() ) );
	}
	
	private void checkIterator(Iterator it){
		List list = new LinkedList();
		
		it.first();
		while(!it.isDone()){
			Map.Entry entry = (Map.Entry)it.current();
			list.add( entry.getKey() );
			it.next();
		}
		
		try{
			it.current();
			fail();
		}
		catch(IteratorOutOfBoundsException e){}
		
		assertSame(list.size(), 3);
		
		assertTrue (  list.contains(entry1.getKey()) );
		assertTrue (  list.contains(entry2.getKey()) );
		assertTrue (  list.contains(entry3.getKey()) );
	}
}

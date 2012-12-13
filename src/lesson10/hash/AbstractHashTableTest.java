package lesson10.hash;

import junit.framework.TestCase;

public abstract class AbstractHashTableTest  extends TestCase{
	private HashTable hashTable;
	private static final int TEST_SIZE = 1000;
	
	protected abstract HashTable createHashTable(int capacity);
	
	protected void setUp() throws Exception{
		super.setUp();
		hashTable = createHashTable(TEST_SIZE);
		
		for(int i=0;i<TEST_SIZE;i++){
			hashTable.add(String.valueOf(i));
		}
	}
	public void testHashTableContainsAddedElements(){
		for(int i=0;i<TEST_SIZE;i++){
			assertTrue(hashTable.contains(String.valueOf(i)) );
		}
	}
	
	public void testHashTableDoesntContains(){
		for(int i=0;i<TEST_SIZE;i++){
			assertFalse(hashTable.contains(String.valueOf(i+TEST_SIZE)) );
		}
	}
	
	public void testCantAddSameElement(){
		int size = hashTable.size();
		for(int i=0;i<TEST_SIZE;i++){
			hashTable.add((String.valueOf(i)) );
		}
		
		assertTrue(size == hashTable.size() );
	}
	
}

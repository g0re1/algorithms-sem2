package lesson10.hash;


import junit.framework.TestCase;

public class HashTableCallCountingTest extends TestCase {
	private int counter;
	private HashTable hashTable;
	
	private static final int TEST_SIZE = 1000;
	private static final int INITIAL_VALUE = 17;
	
	public void testLinearProbingWithoutResize(){
		hashTable = new LinearProbingHashTable(TEST_SIZE);
		this.runAll();
	}
	
	public void testLinearProbingWithResize(){
		hashTable = new LinearProbingHashTable(INITIAL_VALUE);
		this.runAll();
	}
	
	public void testBucketingHashTable75Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 0.75f);
		this.runAll();
	}
	
	public void testBucketingHashTable100Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 1f);
		this.runAll();
	}
	public void testBucketingHashTable50Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 0.50f);
		this.runAll();
	}
	
	public void testBucketingHashTable25Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 0.25f);
		this.runAll();
	}
	
	public void testBucketingHashTable125Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 1.25f);
		this.runAll();
	}
	
	public void testBucketingHashTable150Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 1.50f);
		this.runAll();
	}
	public void testBucketingHashTable200Procent(){
		hashTable = new BucketingHashTable(INITIAL_VALUE, 2.00f);
		this.runAll();
	}
	
	private void runAll(){
		runAdd();
		runContains();
	}
	
	private void runAdd(){
		counter = 0;
		for(int i=0;i<TEST_SIZE;i++){
			hashTable.add(new Value());
		}
		this.reportCalls();
	}
	
	public void runContains(){
		counter=0;
		for(int i=0;i<TEST_SIZE;i++){
			hashTable.contains(new Value());
		}
		this.reportCalls();
	}
	
	private void reportCalls(){
		System.out.println(this.getName() + " " + "wywolan : " + counter);
	}
	
	private final class Value{
		private final String value;
		
		public Value(){
			value = String.valueOf(Math.random()* TEST_SIZE);
		}
		
		public int hashCode(){
			return value.hashCode();
		}
		public boolean equals(Object object){
			counter++;
			return object != null && this.value.equals(((Value)object).value ) ;
		}
	}
}

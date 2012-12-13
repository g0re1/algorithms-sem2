package lesson8.binary.search;

import java.util.Random;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;
import lesson5.sort.test.CallCountingListComparator;

public class BinarySearchCallCountingTest extends TestCase {
	private List sortedList;
	private List randomlySortedList;
	private CallCountingListComparator comparator; 
	
	private static final int TEST_SIZE = 1021;
	
	protected void setUp() throws Exception{
		Random random = new Random();
		comparator = new CallCountingListComparator(NaturalComparator.INSTANCE);
		sortedList = new ArrayList();
		randomlySortedList = new ArrayList();
		
		for(int i=0;i<TEST_SIZE-1;i++){
			sortedList.add(new Integer(i));
			randomlySortedList.add(new Integer(random.nextInt()));
		}
	}
	
	private void reportCall(){
		System.out.println(getName() + " : " + comparator.getCallCount());
	}
	
	public void testRecursiveBinarySearchCallCountingSortedList(){
		performInOrderSearch(new RecursiveBinaryListSearcher(comparator));
	}
	public void testIterativeBinarySearchCallCountingSortedList(){
		performInOrderSearch(new IterativeBinaryListSearcher(comparator));
	}
	public void testLinearSearchCallCountingSortedList(){
		performInOrderSearch(new LinearListSearcher(comparator));
	}
	
	private void performInOrderSearch(ListSearcher searcher){
		for(int i=0;i<TEST_SIZE-1;i++){
			searcher.search(sortedList, new Integer(i));
		}
		reportCall();
	}
	
	public void testRecursiveBinarySearchCallCountingRandomlySortedList(){
		performInRandomOrderSearch(new RecursiveBinaryListSearcher(comparator));
	}
	public void testIterativeBinarySearchCallCountingRandomlySortedList(){
		performInRandomOrderSearch(new IterativeBinaryListSearcher(comparator));
	}
	public void testLinearSearchCallCountingRandomlySortedList(){
		performInRandomOrderSearch(new LinearListSearcher(comparator));
	}
	
	private void performInRandomOrderSearch(ListSearcher searcher){
		for(int i=0;i<TEST_SIZE-1;i++){
			searcher.search(randomlySortedList, new Integer(i));
		}
		reportCall();
	}
	
}

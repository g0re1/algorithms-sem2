package lesson6.test;

import java.util.Random;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.NaturalComparator;
import lesson5.sort.test.CallCountingListComparator;
import lesson6.mergesort.MergeListSorter;
import lesson6.quicksort.QuickListSorter;
import lesson6.shellsort.ShellListSorter;

public class AdvancedSortTestCase extends TestCase {
	private static final int TEST_SIZE = 1000;
	
	private List sortedList;
	private List reverseSortedList;
	private List randomList;
	private List randomDoubleList;
	
	private CallCountingListComparator comparator; 	
	
	protected void setUp() throws Exception{
		super.setUp();
		
		comparator = new CallCountingListComparator(NaturalComparator.INSTANCE);
		
		sortedList = new ArrayList(TEST_SIZE);
		for(int i=0; i<TEST_SIZE;i++){
			sortedList.add(new Integer(i));
		}
		reverseSortedList = new ArrayList(TEST_SIZE);
		for(int i=TEST_SIZE-1; i>-1;i--){
			reverseSortedList.add(new Integer(i));
		}
		Random random = new Random();
		randomList = new ArrayList(TEST_SIZE);
		for(int i=0; i<TEST_SIZE;i++){
			randomList.add(new Integer(random.nextInt(1000)));
		}
		randomDoubleList = new ArrayList(TEST_SIZE);
		for(int i=0; i<TEST_SIZE ; i++){
			randomDoubleList.add(new Double (random.nextDouble() ));
		}
		
	}	
	public void testMergeSortCallCountingSortedList(){
		MergeListSorter merge = new MergeListSorter(comparator);
		sortedList = merge.Sort(sortedList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testMergeSortCallCountingReverseSortedList(){
		MergeListSorter merge = new MergeListSorter(comparator);
		sortedList = merge.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testMergeSortCallCountingRandomList(){
		MergeListSorter merge = new MergeListSorter(comparator);
		sortedList = merge.Sort(randomList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testQuickSortCallCountingSortedList(){
		QuickListSorter quick = new QuickListSorter(comparator);
		sortedList = quick.Sort(sortedList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testQuickSortCallCountingReverseSortedList(){
		QuickListSorter quick = new QuickListSorter(comparator);
		sortedList = quick.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testQuickSortCallCountingRandomList(){
		QuickListSorter quick = new QuickListSorter(comparator);
		sortedList = quick.Sort(randomList);
		System.out.println( comparator.getCallCount() );	
	}
	
	public void testShellSortCallCountingSortedList(){
		ShellListSorter shell = new ShellListSorter(comparator);
		sortedList = shell.Sort(sortedList);
		System.out.println( comparator.getCallCount() );	
		}
	
	public void testShellSortCallCountingReverseSortedList(){
		ShellListSorter shell = new ShellListSorter(comparator);
		sortedList = shell.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );	
		}
	
	public void testShellSortCallCountingRandomList(){
		ShellListSorter shell = new ShellListSorter(comparator);
		sortedList = shell.Sort(randomList);
		System.out.println( comparator.getCallCount() );	
		}
}

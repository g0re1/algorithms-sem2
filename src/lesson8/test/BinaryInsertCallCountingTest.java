package lesson8.test;

import java.util.Random;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.ListSorter;
import lesson5.NaturalComparator;
import lesson5.sort.test.CallCountingListComparator;
import lesson6.mergesort.MergeListSorter;
import lesson6.quicksort.QuickListSorter;
import lesson8.binary.insertion.ListInserter;
import lesson8.binary.search.RecursiveBinaryListSearcher;

public class BinaryInsertCallCountingTest extends TestCase {
	private static final int TEST_SIZE=1023;
	
	private ListInserter inserter;
	private QuickListSorter quickSort;
	private MergeListSorter mergeSort;
	
	private List list;

	
	private CallCountingListComparator comparator;
	
	protected void setUp() throws Exception{
		super.setUp();
		comparator = new CallCountingListComparator(NaturalComparator.INSTANCE);
		list = new ArrayList();
		Random random = new Random();
	}
	
	public void testMergeListSorterCallCountingInsertionSortedList(){
		mergeSort = new MergeListSorter(comparator);
		this.PerformSortedListSorter(mergeSort);
	}
	
	public void testQuickListSorterCallCountingInsertionSortedList(){
		quickSort = new QuickListSorter(comparator);
		this.PerformSortedListSorter(quickSort);
	}
	public void testListInserterCallCountingInsertionSortedList(){
		inserter = new ListInserter(new RecursiveBinaryListSearcher(comparator));
		this.PerformSortedListInserter(inserter);
	}
	public void testMergeListSorterCallCountingInsertionRandomlySortedList(){
		mergeSort = new MergeListSorter(new CallCountingListComparator(comparator));
		this.PerformRandomlySortedListSorter(mergeSort);
	}
	
	public void testQuickListSorterCallCountingInsertionRandomlySortedList(){
		quickSort = new QuickListSorter(new CallCountingListComparator(comparator));
		this.PerformRandomlySortedListSorter(quickSort);
	}
	
	public void testListInserterCallCountingInsertionRandomlySortedList(){
		inserter = new ListInserter(new RecursiveBinaryListSearcher(comparator));
		this.PerformRandomlySortedListInserter(inserter);
	}
	
	private void PerformSortedListSorter(ListSorter sorter){
		for(int i=0;i<TEST_SIZE;i++){
			list.add(new Integer(i));
			sorter.Sort(list);
		}
		System.out.println(comparator.getCallCount());
	}
	private void PerformSortedListInserter(ListInserter inserter){
		for(int i=0;i<TEST_SIZE;i++){
			list.add(new Integer(i));
			inserter.insert(list,new Integer(i));
		}
		System.out.println(comparator.getCallCount());
	}
	private void PerformRandomlySortedListSorter(ListSorter sorter){
		Random r = new Random();
		for(int i=0;i<TEST_SIZE;i++){
			list.add(new Integer(r.nextInt()));
			sorter.Sort(list);
		}
		System.out.println(comparator.getCallCount());
	}
	private void PerformRandomlySortedListInserter(ListInserter inserter){
		Random r = new Random();
		for(int i=0;i<TEST_SIZE;i++){
			inserter.insert(list,new Integer(r.nextInt()));
		}
		System.out.println(comparator.getCallCount());
	}
}
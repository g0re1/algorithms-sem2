package lesson5.sort.test;

import java.util.Random;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.NaturalComparator;
import lesson5.bubblesort.BubbleSortListSorter;
import lesson5.insertionsort.InsertionListSorter;
import lesson5.selectionsort.SelectionListSorter;

public class ListSorterCallCountingComparatorTest extends TestCase{
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
	
	public void testBubbleListSorterCallCountingRandomDoubleList(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		bubble.Sort(randomDoubleList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testSelectionListSorterCallCountingRandomDoubleList(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		selection.Sort(randomDoubleList);
		System.out.println("--Select----");
		System.out.println( comparator.getCallCount() );
	}
	
	public void testInsertionListSorterCallCountingRandomDoubleList(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		insertion.Sort(randomDoubleList);
		System.out.println("--Insert----");
		System.out.println( comparator.getCallCount() );
		
	}
	
	public void testBubbleListSorterCallCountingRandomList(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		bubble.Sort(randomList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testBubbleListSorterCallCountingReverseSortedList(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		bubble.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testBubbleListSorterCallCountingSortedList(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		bubble.Sort(sortedList);
		System.out.println( comparator.getCallCount() );
		
	}
	
	public void testSelectionListSorterCallCountingRandomList(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		selection.Sort(randomList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testSelectionListSorterCallCountingReverseSortedList(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		selection.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testSelectionListSorterCallCountingSortedList(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		selection.Sort(sortedList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testInsertListSorterCallCallCountingRandomList(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		insertion.Sort(randomList);
		System.out.println( comparator.getCallCount() );
		}
	
	public void testInsertListSorterCallCallCountingReverseSortedList(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		insertion.Sort(reverseSortedList);
		System.out.println( comparator.getCallCount() );
	}
	
	public void testInsertListSorterCallCallCountingSortedList(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		insertion.Sort(sortedList);
		System.out.println( comparator.getCallCount() );
	}
}

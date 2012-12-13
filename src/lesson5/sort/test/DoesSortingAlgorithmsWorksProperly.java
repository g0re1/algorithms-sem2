package lesson5.sort.test;

import java.util.Random;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;
import lesson5.bubblesort.BubbleSortListSorter;
import lesson5.insertionsort.InsertionListSorter;
import lesson5.selectionsort.SelectionListSorter;

public class DoesSortingAlgorithmsWorksProperly extends TestCase {
	private static final int TEST_SIZE = 1000;
	private List randomDoubleList;
	private Comparator comparator;
	private List sortedList;
	
	public void setUp(){
		comparator = NaturalComparator.INSTANCE;
		Random random = new Random();
		randomDoubleList = new ArrayList(TEST_SIZE);
		for(int i=0; i<TEST_SIZE ; i++){
			randomDoubleList.add(new Double (random.nextDouble() ));
		}
	}
	
	public void SortedListIsSortedProperly(){
		System.out.println("Next Test");
		for(int i=0; i<TEST_SIZE-1;i++){
			if ( (Double)sortedList.get(i) >= (Double)sortedList.get(i+1) ) fail();
			System.out.println(sortedList.get(i));
		}
	}
	
	public void testBubbleListSorter(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		sortedList = bubble.Sort(randomDoubleList);
		SortedListIsSortedProperly();
	}
	
	public void testSelectionListSorter(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		sortedList = selection.Sort(randomDoubleList);
		SortedListIsSortedProperly();
	}
	
	public void testInsertionListSorter(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		sortedList = insertion.Sort(randomDoubleList);
		SortedListIsSortedProperly();
	}
}

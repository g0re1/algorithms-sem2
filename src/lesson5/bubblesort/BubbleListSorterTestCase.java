package lesson5.bubblesort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class BubbleListSorterTestCase  extends AbstractListSorterTestCase{

	protected ListSorter createListSorter(Comparator comparator) {
		return new  BubbleSortListSorter(comparator);
	}

}

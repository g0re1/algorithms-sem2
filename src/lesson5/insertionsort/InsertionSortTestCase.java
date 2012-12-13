package lesson5.insertionsort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class InsertionSortTestCase extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {
		return new InsertionListSorter(comparator);
	}

}

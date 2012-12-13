package lesson5.selectionsort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class SelectionSortTestCase extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {
		return new SelectionListSorter(comparator);
	}

}

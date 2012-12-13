package lesson6.quicksort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class IterateQuickListSorterTestCase extends AbstractListSorterTestCase {


	protected ListSorter createListSorter(Comparator comparator) {
		return new IterateQuickListSorter(comparator);
	}

}

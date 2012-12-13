package lesson6.shellsort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class ShellSortTestCase extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {
		return new ShellListSorter(comparator);
	}

}

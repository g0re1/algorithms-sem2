package lesson6.mergesort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class MergeSortTestCase extends AbstractListSorterTestCase  {

	protected ListSorter createListSorter(Comparator comparator) {
		return new MergeListSorter(comparator);
	}

}

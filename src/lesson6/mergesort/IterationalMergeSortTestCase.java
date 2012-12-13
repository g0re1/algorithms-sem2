package lesson6.mergesort;

import lesson5.AbstractListSorterTestCase;
import lesson5.Comparator;
import lesson5.ListSorter;

public class IterationalMergeSortTestCase extends AbstractListSorterTestCase  {

	protected ListSorter createListSorter(Comparator comparator) {
		return new IterationalMergeListSorter(comparator);
	}

}

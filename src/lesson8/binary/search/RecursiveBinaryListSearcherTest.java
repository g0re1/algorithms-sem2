package lesson8.binary.search;

import lesson5.Comparator;

public class RecursiveBinaryListSearcherTest extends AbstractListSearcherTest {

	public ListSearcher createSearcher(Comparator comparator) {
		return new RecursiveBinaryListSearcher(comparator);
	}

}

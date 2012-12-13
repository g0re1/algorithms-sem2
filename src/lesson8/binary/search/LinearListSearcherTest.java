package lesson8.binary.search;

import lesson5.Comparator;

public class LinearListSearcherTest extends AbstractListSearcherTest {

	public ListSearcher createSearcher(Comparator comparator) {
		return new LinearListSearcher(comparator);
	}

}

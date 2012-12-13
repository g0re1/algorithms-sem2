package lesson8.binary.search;

import lesson5.Comparator;

public class IterativeBinaryListSearcherTest extends AbstractListSearcherTest {


	public ListSearcher createSearcher(Comparator comparator) {
		return new IterativeBinaryListSearcher(comparator);
	}

}

package lesson8.binary.search;

import junit.framework.TestCase;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public abstract class AbstractListSearcherTest extends TestCase {
	private static final Object[] values = {"B","C","D","F","G","H","I","J","K","L","M","P","Q"};
	private ListSearcher listSearcher;
	private List list;
	
	public abstract ListSearcher createSearcher(Comparator comparator);
	
	protected  void setUp() throws Exception{
		super.setUp();
		listSearcher = createSearcher(NaturalComparator.INSTANCE);
		list = new ArrayList(values);
	}
	
	public void testDoesListSearcherReturnsCorrectValue(){
		for(int i=0; i<list.size()-1;i++){
			assertSame(i,listSearcher.search(list,list.get(i)) );
		}
	}
	
	public void testSearchNonExistingValuesLessThanAllList(){
		assertSame(-1,listSearcher.search(list, "A"));
	}
	
	public void testSearchNonExistingElementGreaterThanAllList(){
		assertSame(-1-list.size(),listSearcher.search(list,"Z") );
	}
	
	public void testSearchforArbitraryNonExistingValue(){
		assertSame(-4,listSearcher.search(list, "E"));
	}
}

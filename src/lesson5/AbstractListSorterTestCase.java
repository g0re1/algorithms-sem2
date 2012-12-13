package lesson5;

import junit.framework.TestCase;
import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;
import lesson5.sort.test.LowerCaseComparator;

public abstract class AbstractListSorterTestCase extends TestCase {
	private List sortedList;
	private List unsortedList;
	
	public void setUp() throws Exception {
		
		unsortedList = new ArrayList();
		
		unsortedList.add("Programowanie");
		unsortedList.add("sterowane");
		unsortedList.add("testami");
		unsortedList.add("to");
		unsortedList.add("mały");
		unsortedList.add("krok");
		unsortedList.add("dla");
		unsortedList.add("programisty");
		unsortedList.add("lecz");
		unsortedList.add("olbrzymi");
		unsortedList.add("skok");
		unsortedList.add("w");
		unsortedList.add("dziejach");
		unsortedList.add("programowania");
		
		sortedList = new ArrayList();
		
		sortedList.add("dla");
		sortedList.add("dziejach");
		sortedList.add("krok");
		sortedList.add("lecz");
		sortedList.add("mały");
		sortedList.add("olbrzymi");
		sortedList.add("programisty");
		sortedList.add("programowania");
		sortedList.add("Programowanie");
		sortedList.add("skok");
		sortedList.add("sterowane");
		sortedList.add("testami");
		sortedList.add("to");
		sortedList.add("w");
			
		}
	protected void tearDown() throws Exception{
		sortedList = null;
		unsortedList = null;
	}		
	
	protected abstract ListSorter createListSorter(Comparator comparator);
	
	public void testListSorterCanSortSimpleList(){
		ListSorter listSorter = createListSorter(LowerCaseComparator.INSTANCE);
		List listResult = listSorter.Sort(unsortedList);
		
		assertEquals(listResult.size(), sortedList.size());
		
		Iterator actual = listResult.iterator();
		actual.first();
		
		Iterator expected = sortedList.iterator();
		expected.first();
		
		while(!actual.isDone()){
			System.out.println( actual.current()+ " "+expected.current() );
			assertEquals(actual.current(), expected.current());
			actual.next();
			expected.next();
		}
	}
}

package lesson8.binary.insertion;

import java.util.Random;

import junit.framework.TestCase;
import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.LinkedList;

import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;
import lesson8.binary.search.IterativeBinaryListSearcher;

public class ListInserterTest extends TestCase {
	private List list;
	private ListInserter inserter;
	private Comparator comparator;
	private static final int TEST_SIZE = 1021;
	
	protected void setUp() throws Exception {
		super.setUp();
		list = new ArrayList();
		inserter = new ListInserter(new IterativeBinaryListSearcher(NaturalComparator.INSTANCE));
		comparator = NaturalComparator.INSTANCE;
	}
	
	private void verify(){
		System.out.println("new veryfiy");
		Iterator it = list.iterator();
		it.first();
		Object previous = it.current();
		while(!it.isDone()){
			System.out.println(it.current());
			assertTrue(comparator.compare(it.current(), previous) >= 0 );
			previous = it.current();
			it.next();
		}
	}
	
	public void testInsertListInPreOrder(){
		for(int i=0;i<TEST_SIZE-1;i++){
			inserter.insert(list,new Integer(i));
		}
		verify();
	}
	public void testInsertListInPostOrder(){
		for(int i=TEST_SIZE-1;i>-1;i--){
			inserter.insert(list,new Integer(i));
		}
		verify();
	}
	public void testInsertListInRandomOrder(){
		Random random = new Random();
		for(int i=TEST_SIZE-1;i>-1;i--){
			inserter.insert(list,new Integer(random.nextInt(TEST_SIZE)));
		}
		verify();
	}
	
}

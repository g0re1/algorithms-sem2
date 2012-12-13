package lesson8.binary.insertion;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.NaturalComparator;
import lesson8.binary.search.IterativeBinaryListSearcher;
import lesson8.binary.search.ListSearcher;
import lesson8.binary.search.RecursiveBinaryListSearcher;

public class ListInserter {
	private ListSearcher searcher;
	
	public ListInserter(ListSearcher searcher) {
		this.searcher = searcher;
	}
	
	public static void main(String[] args){
		ListInserter inserter = new ListInserter(new RecursiveBinaryListSearcher(NaturalComparator.INSTANCE));
		List list = new ArrayList();
		
		for(int i=0;i<3;i++){
			inserter.insert(list, new Integer(i) ) ;
		}
		Iterator it =list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
	}

	public int insert(List list, Object el) {
		assert list != null :"List cannot be null";
		int index = searcher.search(list, el);

		if(index < 0) index = -(index+1);
		//System.out.println(index);
		list.insert(index, el);
		
		return index;
	}
}

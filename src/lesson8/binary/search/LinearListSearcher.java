package lesson8.binary.search;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class LinearListSearcher implements ListSearcher {
	private Comparator comparator;
	
	public LinearListSearcher(Comparator comparator) {
		this.comparator = comparator;
	}
	
	public static void main(String[] args){
		final Object[] values = {"B","C","D","F","G","H","I","J","K","L","M","P","Q"};
		List list = new ArrayList(values);
		ListSearcher searcher = new LinearListSearcher(NaturalComparator.INSTANCE);
		
		System.out.println( searcher.search(list, "B") );
		System.out.println(list.get( searcher.search(list, "B") ));

	}

	public int search(List list, Object key) {
		Iterator it = list.iterator();
		it.first();
		int current;
		
		while(!it.isDone()){
			if(comparator.compare(it.current(),key ) == 0){
				return list.indexOf(key);
			}
			if(comparator.compare(it.current(),key ) > 0){
				return -list.indexOf( it.current() )-1;
			}
			it.next();
		}
		current = -1;
		if( comparator.compare(key, list.get(list.size()-1)) > 0)return -list.size();
		
		return current;
	}

}

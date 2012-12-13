package lesson8.binary.search;

import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class RecursiveBinaryListSearcher implements ListSearcher {
	private Comparator comparator;
	
	public RecursiveBinaryListSearcher(Comparator comparator) {
		assert comparator != null : "Comparator cannot be null";
		this.comparator = comparator;
	}
	
	public static void main(String[] args){
		final Object[] values = {"B","C","D","F","G","H","I","J","K","L","M","P","Q"};
		List list = new ArrayList(values);
		ListSearcher searcher = new RecursiveBinaryListSearcher(NaturalComparator.INSTANCE);
		
		System.out.println( searcher.search(list, "I") );
		System.out.println(list.get( searcher.search(list, "I") ));

	}

	public int search(List list, Object key) {		
		return binarySearch(list,key,0,list.size()-1);
	}
	
	private int binarySearch(List list, Object key,int lowerIndex,int upperIndex){
		assert list != null : "List cannot be null";
		if(lowerIndex > upperIndex)return -lowerIndex-1;
		
		int current = lowerIndex + (upperIndex-lowerIndex)/2;
		int cmp = comparator.compare(key,list.get(current) );
		
		if(cmp< 0)return current = binarySearch(list,key,lowerIndex,current-1);
		if(cmp> 0)return current = binarySearch(list,key,current+1,upperIndex);
		

		return current;
	}
	
}

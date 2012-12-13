package lesson8.binary.search;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.NaturalComparator;

public class IterativeBinaryListSearcher implements ListSearcher {
	private Comparator comparator;
	
	public IterativeBinaryListSearcher(Comparator comparator) {
		this.comparator = comparator;
	}
	
	public static void main(String[] args){
		final Object[] values = {"B","C","D","F","G","H","I","J","K","L","M","P","Q"};
		List list = new ArrayList(values);
		ListSearcher searcher = new IterativeBinaryListSearcher(NaturalComparator.INSTANCE);
		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(searcher.search(list, it.current()));
			it.next();
		}
	}
	public int search(List list, Object key) {
		assert list != null :"List cannot be null";
		assert key != null :"Key cannot be null";

		int lowerIndex = 0;
		int upperIndex = list.size()-1;
		
		int current=0; 

		while(lowerIndex <= upperIndex){
			current = lowerIndex + (upperIndex-lowerIndex)/2;
			int cmp = comparator.compare(key,list.get(current));
			//System.out.println(current);
			if(cmp == 0){return current;}
			else if(cmp < 0) {
				upperIndex = current-1;
			}
			else if(cmp > 0){
				lowerIndex=current+1; 
			}
		}
		return -lowerIndex-1;
	}
}

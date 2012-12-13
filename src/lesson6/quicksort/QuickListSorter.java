package lesson6.quicksort;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;

public class QuickListSorter implements ListSorter {
	private Comparator  comparator;
	
	public QuickListSorter(Comparator comparator) {
		this.comparator = comparator;
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		for(int i=10; i>-1; i--){
			list.add(i);
		}
		list.add(5);
		QuickListSorter quick = new QuickListSorter(NaturalComparator.INSTANCE);
		list = quick.Sort(list);
		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
	}

	public List Sort(List list) {
		
		quickSort(list, 0, list.size()-1);	
		
		return list;
	}
	
	private void quickSort(List list, int startIndex, int endIndex){
		
		if ( (startIndex < 0 )|| (endIndex > list.size()-1) ) return;
		if(startIndex >= endIndex) return;
		
		Object divide = list.get(endIndex);
		
		int partition = partition(list,divide,startIndex,endIndex-1);
		if (comparator.compare(list.get(partition), divide) < 0){
			++partition;
		}
		swap(list,partition,endIndex);
		
		quickSort(list,startIndex,partition-1);
		quickSort(list,partition+1,endIndex);
		
	}
	
	private int partition(List list,Object divide, int startIndex, int endIndex){
		int left = startIndex;
		int right = endIndex;
		
		while (left < right){
			if(comparator.compare(list.get(left), divide ) < 0){
				left++;
				continue;
			}	
			if (comparator.compare(list.get(right), divide ) >= 0){
				right--;
				continue;
			}	
			if(comparator.compare(list.get(left), list.get(right) )>0) swap(list,left,right);
			left++;
		}
		return left;
	}
	
	private void swap(List list,int left, int right){
		if(left==right)return;
		
		Object obj = list.get(left);
		list.set(left, list.get(right));
		list.set(right, obj);
	}
}

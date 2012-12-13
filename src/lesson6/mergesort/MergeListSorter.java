package lesson6.mergesort;

import lesson1.Iterator;
import lesson2.AbstractList;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;

public class MergeListSorter implements ListSorter{	
	private Comparator comparator;
	
	public MergeListSorter(Comparator comp){
		this.comparator = comp;
	}
	
	public static void main(String[] args) {
		List list = new ArrayList();
		for(int i=0; i<12; i++){
			list.add(i);
		}
		MergeListSorter merge = new MergeListSorter(NaturalComparator.INSTANCE);
		list = merge.Sort(list);
		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
	}
	
	public List Sort(List list) {
		
		return mergeSort(list,0,list.size()-1);
	
	}

	private List mergeSort(List list, int startIndex, int endIndex) {
		
		if(startIndex == endIndex) {
			List result = new ArrayList();
			result.add(list.get(startIndex));
			return result;
		}
		int splitIndex =  startIndex+( endIndex - startIndex)/2;
		
	//	System.out.println(splitIndex);

		
		List left = mergeSort(list,startIndex,splitIndex);
		List right = mergeSort(list,splitIndex+1,endIndex);
		
		return merge(left,right);
	}
	
	private List merge(List left, List right)
	{
		List result = new ArrayList();
		Iterator leftIt = left.iterator();
		Iterator rightIt = right.iterator();
		leftIt.first();
		rightIt.first();
		
		while(!( leftIt.isDone()  &&  rightIt.isDone() ) ){
			if (leftIt.isDone()) {
				result.add(rightIt.current() );
				rightIt.next();
			}
			else{ if(rightIt.isDone()){
				result.add(leftIt.current() );
				leftIt.next();
				}
				else if(comparator.compare(leftIt.current(), rightIt.current()) >=0){
					result.add(rightIt.current() );
					rightIt.next();
				}
				else{result.add( leftIt.current() );
					leftIt.next();
				}
			}

		}
		//System.out.println( ((AbstractList)result).toString());
		return result;
		
	}
}

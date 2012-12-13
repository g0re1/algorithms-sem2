package lesson6.mergesort;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson4.ListStack;
import lesson4.Stack;
import lesson5.Comparator;
import lesson5.ListSorter;

public class IterationalMergeListSorter implements ListSorter{
	private Comparator comparator;
	
	public IterationalMergeListSorter(Comparator comp){
		this.comparator = comp;
	}

	public List Sort(List list) {
		Stack resultStack = new ListStack();
		
	
		return list;
	}
	
	private List sub(List list, int startIndex, int endIndex){
		
		int splitIndex = startIndex + (endIndex - startIndex)/2;
		
		return list;
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
		return result;
	}
}

package lesson6.shellsort;

import java.util.Random;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson3.ListFifoQueue;
import lesson3.Queue;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;
import lesson5.insertionsort.InsertionListSorter;

public class ShellListSorter implements ListSorter {
	private Comparator comparator;
	private final int[] increments = {121,40,13,4,1};
	
	public static void main(String[] args){
		List list = new ArrayList();
		Random r = new Random();
		for(int i=100;i>-1;i--){
			list.add(r.nextInt(100));
		}
		
		ShellListSorter shell = new ShellListSorter(NaturalComparator.INSTANCE);
		List sortedList = shell.Sort(list);
		
		Iterator it = sortedList.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println( it.current() );
			it.next();
		}
	}
	
	public ShellListSorter(Comparator comp){
		this.comparator = comp;
	}
	
	public List Sort(List list) {
		InsertionListSorter insert = new InsertionListSorter(comparator );
		int size = list.size();
		for(int i=0; i<increments.length;i++){
			if(increments[i] > size) continue;
			int j=0;
			while(j!=increments[i]){
				int k=0;
				Queue kAll = new ListFifoQueue();
				List hSortList  = new ArrayList();
				while(k<size){
					hSortList.add(list.get(k) );
					kAll.enqueue(new Integer(k));
					k+=increments[i];
				}
				hSortList = insert.Sort(hSortList);
				Iterator it = hSortList.iterator();
				it.first();
				while(!it.isDone()){
					list.set( (Integer)kAll.dequeue(), it.current());
					it.next();
				}		
				j++;
			}
		}	
		return list;
	}
}
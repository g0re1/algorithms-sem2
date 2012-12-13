package lesson5.bubblesort;

import lesson1.Iterator;
import lesson2.AbstractList;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;

public class BubbleSortListSorter implements ListSorter {
	private Comparator comparator;

	public BubbleSortListSorter(Comparator comparator){
		this.comparator = comparator;
	}
	
	public static void main(String[] args){
		BubbleSortListSorter bubbleSort = new BubbleSortListSorter( NaturalComparator.INSTANCE );
		List unsortedList = new ArrayList();
		unsortedList.add("programowanie");
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
		

		List sortedList = bubbleSort.Sort(unsortedList);
		
		Iterator it = sortedList.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
		
	}
	
	public List Sort(List list) {

		for(int i=0; i<list.size()-1;i++){
			for(int j=0;j<list.size()-i-1;j++){
				Object left = list.get(j);
				Object right = list.get(j+1);
				if ( comparator.compare(left,right) > 0 ) 
				{
					swap(list,j,j+1);

				}
			}
		}

		return list;
	}
	public void swap(List list,int i, int j){
		Object left = list.get(i);
		list.set(i, list.get(j));
		list.set(j, left);
	}

}

package lesson5.selectionsort;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;

public class SelectionListSorter implements ListSorter {
	private Comparator comparator;
	
	public SelectionListSorter(Comparator comparator){
		this.comparator = comparator;
	}

	public static void main(String[] args){
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
		
		SelectionListSorter selection = new SelectionListSorter(NaturalComparator.INSTANCE);
		List sortedList = selection.Sort(unsortedList);
		
		Iterator it = sortedList.iterator();
		it.first();

		while(!it.isDone()) {
			System.out.println(it.current());
			it.next();
		}
	}
	
	public List Sort(List list) {
		int size = list.size();
		List newList = new ArrayList(size);
		
		for(int i=0; i<size-1;i++){
			Object biggest = list.get(0);
			
			for(int j=0; j<list.size()-1;j++){
				 Object right = list.get(j+1);
			   	if ( comparator.compare(biggest, right) > 0) biggest = right;
			}

			newList.add( list.delete(biggest) );
		}

		newList.add(list.delete(list.get(0)));
		return newList;
	}
	
}

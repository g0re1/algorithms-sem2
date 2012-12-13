package lesson5.insertionsort;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.ListSorter;
import lesson5.NaturalComparator;

public class InsertionListSorter implements ListSorter {
	private Comparator  comparator;
	
	public InsertionListSorter(Comparator comparator) {
		this.comparator = comparator;
	}
	
	public static void main(String[] args) {
		List unsortedList = new ArrayList();
		unsortedList.add(1);
		unsortedList.add(10);
		unsortedList.add(5);
		unsortedList.add(2);
		unsortedList.add(7);
		unsortedList.add(8);
		unsortedList.add(1);
		unsortedList.add(3);
		unsortedList.add(6);
		unsortedList.add(9);
		
		InsertionListSorter insertion = new InsertionListSorter(NaturalComparator.INSTANCE);
		List sortedList = insertion.Sort(unsortedList);
		
		Iterator it = sortedList.iterator();
		it.first();
		
		while(!it.isDone()){
			System.out.println(it.current());
			it.next();
		}
	}

	public List Sort(List list) {
		int c=0;
		ArrayList newList = new ArrayList(list.size());
		newList.add(list.delete( list.get(0) ) );
		int size = list.size();
		
		for(int i=0; i<size; i++){
			Object current = list.delete(list.get(0) );

			for(int j=newList.size()-1; j>-1;j--){	

				if(comparator.compare(current,newList.get(j)) > 0 ){
					newList.insert(j+1, current);

					break;
				}
				if(j==0){
					c++;
					newList.insert(0, current);
					break;
				}
				
			}	
	
		}
		return newList;
	}
	
}



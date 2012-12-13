package lesson6.comparator;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;

public class CompoundComparator implements Comparator{
	private  final List comparatorList = new ArrayList();

	public void add(Comparator comparator) {
		assert comparator != null : "Comparator nie może być równy null";
		assert comparator != this : "Nie można dodać comparatora cząstkowego";
		comparatorList.add(comparator);
	}
	
	public int compare(Object left, Object right) throws ClassCastException {
		int result;
		for(int i=0; i< comparatorList.size(); i++){
			result = ((Comparator)comparatorList.get(i)).compare(left, right) ;
			if ( result != 0) return result;
		}
		return  0;
	}

}

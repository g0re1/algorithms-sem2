package lesson5.sort.test;

import lesson5.Comparator;
import lesson5.sort.test.DoesSortingAlgorithmsAreStable.Person;

public class PersonComparator implements Comparator {
	public final static PersonComparator INSTANCE = new PersonComparator();
	
	private PersonComparator(){}
	
	public int compare(Object left, Object right) throws ClassCastException{
		assert left != null : "Nie określono lewego obiektu";
		Person pleft = (Person)left;
		Person pright = (Person)right;
		return ((Comparable)pleft.getLastName()).compareTo(pright.getLastName() ) ;
	}

}


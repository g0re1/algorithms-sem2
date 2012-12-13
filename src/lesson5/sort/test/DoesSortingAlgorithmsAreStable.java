package lesson5.sort.test;

import junit.framework.TestCase;
import lesson2.AbstractList;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.Comparator;
import lesson5.bubblesort.BubbleSortListSorter;
import lesson5.insertionsort.InsertionListSorter;
import lesson5.selectionsort.SelectionListSorter;

public class DoesSortingAlgorithmsAreStable extends TestCase {
	private static final int TEST_SIZE = 5;
	private List personList;
	private Comparator comparator;
	private List sortedList;
	private List personListClone;
	
	public class Person{
		private  String firstName;
		private String lastName;
		
		public Person(String f, String l){
			this.setFirstName(f);
			this.setLastName(l);
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getLastName() {
			return lastName;
		}
		
			
	}
	
	public void setUp(){
		comparator = PersonComparator.INSTANCE;
		personList = new ArrayList();

			personList.add(new Person("Paweł", "Szczepkowski"));
			personList.add(new Person("Jarek", "Szczepkowski"));
			personList.add(new Person("Leszek", "Szczepkowski"));
			personList.add(new Person("Stefan", "Szczepkowski"));
			personList.add(new Person("Jurek", "Szczepkowski"));
			
		personListClone = new ArrayList();
			
		personListClone.add(new Person("Paweł", "Szczepkowski"));
		personListClone.add(new Person("Jarek", "Szczepkowski"));
		personListClone.add(new Person("Leszek", "Szczepkowski"));
		personListClone.add(new Person("Stefan", "Szczepkowski"));
		personListClone.add(new Person("Jurek", "Szczepkowski"));
	}
	
	public void SortedListIsSortedProperly(){
		System.out.println("Next Test");
		for(int i=0; i<TEST_SIZE-1;i++){
			if ( ((Person)sortedList.get(i)).getFirstName() != ((Person)personListClone.get(i)).getFirstName() ) fail();
			System.out.println(( (Person)sortedList.get(i) ).getFirstName() + " " +((Person)personListClone.get(i)).getFirstName() );
		}
	}

	public void testBubbleListSorter(){
		BubbleSortListSorter bubble = new BubbleSortListSorter(comparator);
		sortedList = bubble.Sort(personList);
		SortedListIsSortedProperly();
	}
	public void testSelectionListSorter(){
		SelectionListSorter selection = new SelectionListSorter(comparator);
		sortedList = selection.Sort(personList);
		SortedListIsSortedProperly();
	}
/*	public void testInsertionListSorter(){
		InsertionListSorter insertion = new InsertionListSorter(comparator);
		sortedList = insertion.Sort(personList);
		SortedListIsSortedProperly();
	}*/
	
	
}

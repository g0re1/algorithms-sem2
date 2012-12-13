package lesson11.set.exercise;

import lesson1.Iterator;
import lesson11.set.Set;
import lesson2.ArrayList;
import lesson2.List;
import lesson5.NaturalComparator;
import lesson8.binary.insertion.ListInserter;
import lesson8.binary.search.RecursiveBinaryListSearcher;

public class SortedListSet implements Set {
	private List list;
	
	public SortedListSet(){
		clear();
	}
	
	public boolean add(Object value) {
		if(contains(value)) return false;
		ListInserter inserter = new ListInserter(new RecursiveBinaryListSearcher(NaturalComparator.INSTANCE));
		inserter.insert(list, value);
		return true;
	}

	public void clear() {
		list = new ArrayList();
	}

	public boolean contains(Object value) {
		return list.contains(value);
	}

	public boolean delete(Object value) {
		if(!contains(value)) return false;
	
		return list.delete(list.indexOf(value));
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public Iterator iterator() {
		return list.iterator();
	}

}

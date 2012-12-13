package lesson11.set;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;

public class ListSet implements Set {
	private List list = new ArrayList();

	public static void main(String[] args){
	}
	
	public boolean add(Object value) {
		if(list.contains(value)) return false;
		list.add(value);
		return true;
	}

	public void clear() {
		list.clear();
	}

	public boolean contains(Object value) {
		return list.contains(value);
	}

	public boolean delete(Object value) {
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

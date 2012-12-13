package lesson4.exercise;

import lesson1.Iterator;
import lesson2.AbstractList;
import lesson2.ArrayList;
import lesson2.LinkedList;
import lesson2.List;
import lesson4.ListStack;
import lesson4.Stack;

public class UndoableList implements List {
	private AbstractList list;
	private Stack stack = new ListStack();

	public UndoableList(List list ) {
		this.list = (AbstractList) list;
	}
	
	public static void main(String[] args){
		UndoableList list = new UndoableList(new ArrayList() );
		
		list.add("A");
		list.add("B");
		
		list.undo();
		
		System.out.println(list.size() );
	
	}

	public void add(Object element) {
		pushListOnStack();
		list.add(element);
	}
	
	private void pushListOnStack(){
		AbstractList newList = (AbstractList) list.clone();
		stack.push(newList);
	}
	public void undo(){
		list = (ArrayList)stack.pop();
	}
	
	public boolean canUndo(){
		return !stack.isEmpty();
	}

	public void clear() {
		list.clear();
		stack.clear();
	}

	public boolean contains(Object element) {
		return list.contains(element);
	}

	public boolean delete(int id) {
		pushListOnStack();
		return list.delete(id);
	}

	public Object delete(Object element) throws IndexOutOfBoundsException {
		pushListOnStack();
		return list.delete(element);
	}

	public Object get(int id) throws IndexOutOfBoundsException {
		pushListOnStack();
		return list.get(id);
	}

	public int indexOf(Object element) {
		return list.indexOf(element);
	}

	public void insert(int index, Object element)throws IndexOutOfBoundsException {
		pushListOnStack();
		list.insert(index,element);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Object set(int index, Object element)throws IndexOutOfBoundsException {
		pushListOnStack();
		return list.set(index, element);
	}

	public int size() {
		return list.size();
	}

	public Iterator iterator() {
		return list.iterator();
	}

}

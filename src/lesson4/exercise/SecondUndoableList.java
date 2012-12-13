package lesson4.exercise;

import lesson1.Iterator;
import lesson2.AbstractList;
import lesson2.ArrayList;
import lesson2.List;
import lesson4.ListStack;
import lesson4.Stack;


public class SecondUndoableList implements List {
	 private List list;
	 private Stack stack = new ListStack() ;
	
	public SecondUndoableList( List list ) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		SecondUndoableList list = new SecondUndoableList(new ArrayList() );
		
		list.add("A");
		list.add("B");
		System.out.println(list.size());
		list.undo();
		list.undo();
		System.out.println(list.size());
		
		System.out.println(list.canUndo());
	}
	
	private static interface UndoAction {
		public void execute();
	}
	
	private class UndoInsert implements UndoAction{
		private int index;
		
		public UndoInsert(int index){
			this.index = index;
		}
		
		public void execute() {
			list.delete(index);	
		}
	}
	
	public void insert(int index, Object element)throws IndexOutOfBoundsException {
		stack.push(new UndoInsert(index) );
		list.insert(index, element);
	}
	public void add(Object element) {
		insert(list.size(),element);
	}
	
	public void undo(){
		( (UndoAction)stack.pop()).execute();
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

	private class UndoDelete implements UndoAction{
		private int index;
		private Object element;
		
		public UndoDelete(int index, Object element){
			this.index = index;
			this.element = element;
		}
		
		public void execute() {
			list.insert(index, element);
		}
	}
	public boolean delete(int id) {
		stack.push(new UndoDelete(id,list.get(id) ) ) ;
		return 	list.delete(id);
	}

	public Object delete(Object element) throws IndexOutOfBoundsException {
		stack.push(new UndoDelete(list.indexOf(element),element ) );
		return list.delete(element);
	}

	public Object get(int id) throws IndexOutOfBoundsException {
		return list.get(id);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	private class UndoSet implements UndoAction{
		private int index;
		private Object element;
		
		public UndoSet(int index, Object element){
			this.index = index;
			this.element = element;
		}
		public void execute() {
			list.set(index, element);	
		}	
	}
	
	public Object set(int index, Object element)throws IndexOutOfBoundsException {
		Object el = list.set(index, element);
		stack.push(new UndoSet(index,el));
		return el;
	}

	public int size() {
		return list.size();
	}

	public Iterator iterator() {
		return list.iterator();
	}
	
	public int indexOf(Object element) {
		return list.indexOf(element);
	}
	
}

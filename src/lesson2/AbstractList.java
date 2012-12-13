package lesson2;

import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public abstract class AbstractList implements List, Cloneable {
	
	public Object clone(){
		try{
			return super.clone();
		}
		catch(CloneNotSupportedException e){return null;}
	}
	
	public boolean equals(Object other){
		List oth = (List) other;
		if(! ( oth.size() == size() ) )return false;
			
		Iterator it = iterator();
		Iterator it2 = oth.iterator();
		it.first();
		it2.first();	
		while(!it.isDone() && it2.isDone()){
			if(( it.current() != it2.current() ) ) return false;
			it.next();
			it2.next();
		}	
		return true;	
	}
	
	public String toString(){
		Iterator it = iterator();
		it.first();
		String s = "[ ";
		while(!it.isDone()){
			s+= it.current()+", ";
			it.next();
		}
		s+=" ]";
		return s;
	}
	
	public int indexOf(Object element){
		Iterator it = iterator();
		it.first();
		int i=0;
		while(!it.isDone()){
			if( (it.current() == element) ) return i;
		}
		return -1;
	}
	
	public Object[] toArray(){
		Object[] tbl = new Object[size()];
		for(int i=0; i<size();i++){
			tbl[i] = get(i);
		}
		return tbl;
	}
	
	
	
	public Iterator UIterator (){
		return new UIterator();
		
	}
	private class UIterator implements Iterator{
		Iterator it = iterator();
		
		public Object current() throws IteratorOutOfBoundsException {
			return it.current();
		}
		public void first() {
			it.first();
		}
		public boolean isDone() {
			return it.isDone();
		}
		public void last() {
			it.last();	
		}
		public void next() {
			it.next();
		}
		public void previous() {
			it.previous();
		}	
	}
}

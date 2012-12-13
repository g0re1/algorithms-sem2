package lesson11.set;

import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public class HashSet implements Set {
	public static final int DEFAULT_CAPACITY = 17;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private final int initialCapacity;
	private final float loadFactor;
	private int size;
	
	private ListSet[] listSets;
	
	public HashSet(){
		this.initialCapacity = DEFAULT_CAPACITY;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		clear();
	}
	
	public HashSet(int initialCapacity){
		this.initialCapacity = initialCapacity;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		clear();
	}
	
	public HashSet(int initialCapacity, float loadFactor){
		this.initialCapacity = initialCapacity;
		this.loadFactor = loadFactor;
		clear();
	}
	
	public static void main(String[] args) {
		HashSet hash = new HashSet();
		for(int i=0; i<15;i++){
			hash.add(i);
		}	
		
		for(int i=15; i<30;i++){
			hash.add(i);
		}

		Iterator it = hash.iterator();
		it.last();
		while(!it.isDone()){
			System.out.println(it.current());
			it.previous();
		}
		Set hash2 = new HashSet();
		for(int i=15; i<30;i++){
			hash2.add(i);
		}
		
		System.out.println( hash.equals(hash2) );
		
		System.out.println( hash.newDelete(3) );
		
		System.out.println(hash.toString());
		
	}
	
	public boolean equals(Object object){
		if(object instanceof Set){
			Set other = (Set)object;
			Iterator it1 = this.iterator();
			Iterator it2 = other.iterator();
			it1.first();
			it2.first();
			while(!it1.isDone() || !it2.isDone()){
				if(it1.current() != it2.current()) return false;
				it1.next();
				it2.next();
			}
		}

		return true;
	}
	
	public String toString(){
		String s="[ ";
		for(int i=0;i<listSets.length;i++){
			if(listSets[i] == null) continue;
			Iterator it = listSets[i].iterator();
			it.first();
			while(!it.isDone()){
				s += it.current().toString() + ", ";
				it.next();
			}
		}
		s += " ]";
		return s;
	}
	
	public boolean add(Object value) {
		assert value != null :"Value cannot be null";
		
		if(contains(value)) return false;
		ensureCapacity();
		
		String val = String.valueOf(value);
		
		int hash = Math.abs( val.hashCode()) % listSets.length;
		
		if(listSets[hash] == null) listSets[hash] = new ListSet();
		listSets[hash].add(value);
		size++;
		
		return true;
	}
	
	private void ensureCapacity(){
		if(size/listSets.length >= loadFactor){
			ListSet[] newListSets = new ListSet[2*initialCapacity];
			for(int i=0;i<listSets.length;i++){
				newListSets[i] = listSets[i];
			}
			listSets = newListSets;
		}
	}

	public void clear() {
		listSets = new ListSet[initialCapacity];
		size=0;
	}

	public boolean contains(Object value) {
		//String val = String.valueOf(value);
		
		for(int i=0;i<listSets.length;i++){
			if (listSets[i] == null) continue;
			Iterator it =listSets[i].iterator();
			it.first();
			while(!it.isDone()){
				if(it.current().equals(value)) return true;
				it.next();
			}
		}
		return false;
	}
	
	public boolean newDelete(Object value){
		if(!contains(value)) return false;
		
		for(int i=0;i<listSets.length;i++){
			if (listSets[i] != null){
				listSets[i] = null; 	
				break;
			}
		}
		return true;
	}

	public boolean delete(Object value) {
		if(!contains(value)) return false;
		
		for(int i=0;i<listSets.length;i++){
			if (listSets[i] == null) continue;
			if(listSets[i].contains(value)){
				listSets[i].delete(value);
				size--;
				break;
			}
		}
		return true;
	}
	public boolean isEmpty() {
		return size==0 ? true : false;
	}

	public int size() {
		return size;
	}

	public Iterator iterator() {
		return new HashSetIterator();
	}

	private final class HashSetIterator implements Iterator{
		private Iterator it;
		private int i=0;
		private int itc; // iterator current

		public Object current() throws IteratorOutOfBoundsException {
			if (isDone()) throw new IteratorOutOfBoundsException();
			return it.current();
		}
		
		public void first() {
			for(itc=0;itc<listSets.length;itc++){
				if (listSets[itc] == null) continue;
				it =listSets[itc].iterator();
				it.first();
				break;
			}
		}

		public boolean isDone() {
			
	//		System.out.println("i = "+i+ " and size is = "+size);
			return size == i ? true : false;
		}

		public void last() {
			for(itc=listSets.length-1;itc>-1;itc--){
				if (listSets[itc] == null) continue;
				it =listSets[itc].iterator();
				it.first();
				break;
			}
		}
		public void next() {
			it.next();
			if (it.isDone())getNextIt();
			i++;
		}
		
		private void getNextIt(){
			for( itc = itc+1; itc<listSets.length ; itc++){

				if (listSets[itc] == null) continue;
				it = listSets[itc].iterator();
				it.first();

				break;
			}
		}

		public void previous() {
			it.next();
			if(it.isDone()) getPreviousIt();
			i++;
		}
		private void getPreviousIt(){
			for(itc=itc-1;itc>-1;itc--){
				
				if (listSets[itc] == null) continue;
				it = listSets[itc].iterator();
				it.first();
				break;
			}
		//	i++;
		}
	}
}

package lesson12.map;

import lesson1.ArrayIterator;
import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;

public class HashMap implements Map {
	private static final int DEFAULT_CAPACITY = 17; 
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int initialCapacity;
	private float loadFactor;
	
	private ListMap[] listMaps;
	private int size;
	
	public HashMap(){
		this.initialCapacity = DEFAULT_CAPACITY;
		this.loadFactor = DEFAULT_LOAD_FACTOR ;
		clear();
	}
	public HashMap(int initialCapacity, float loadFactor){
		this.initialCapacity = initialCapacity;
		this.loadFactor = loadFactor;
		clear();
	}
	
	public static void main(String[] args){
		
		HashMap hashMap = new HashMap();
		hashMap.set("Jarek", 5);
		hashMap.set("Pawel", 6);
		hashMap.set("Stefan", 7);
		hashMap.set("Alek", 7);
		
		hashMap.delete("Stefan");
		hashMap.delete("Alek");
		
		System.out.println(hashMap.show());
		
	/*	Iterator it = hashMap.iterator();
		it.first();
		while(!it.isDone() ){
			System.out.println(it.current() );
			it.next();
		}*/
		
	//	System.out.println(hashMap.toString());
	}
	
	public String show(){
		String s ="[ ";
		for(int i=0;i<listMaps.length;i++){
			if(listMaps[i] == null) continue;
			s+=listMaps[i].toString()+", "  ;
		}
		return s+=" ]";
	}
	
	public String toString(){
		
		Iterator it = this.iterator();
		it.first();
		String s = "[ ";
		while(!it.isDone()){
			s+= it.current()+", ";
			it.next();
		}
		return s+=" ]";
			
	}
	public void clear() {
		listMaps = new ListMap[initialCapacity];
		size=0;
	}

	public boolean contains(Object key) {
		Iterator it = this.iterator();
		it.first();
		while(!it.isDone()){
			Map.Entry current = ((Map.Entry)it.current());
			if (current.getKey() == key ) return true;
			it.next();
		}
		return false;
	}

	public Object delete(Object key) { 
		
		for(int i=0;i<listMaps.length;i++){
			if(listMaps[i] == null) continue;
			if (listMaps[i].contains(key)) {
				listMaps[i].delete(key);
				if(listMaps[i].isEmpty() ) listMaps[i] = null;
				size--;
			}
		}
		
		return null;
	}

	public Object get(Object key) {
		
		Iterator it = this.iterator();
		it.first();
		while(!it.isDone()){
			Map.Entry current = ((Map.Entry)it.current());
			if (current.getKey() == key ) return current.getValue() ;
			it.next();
		}
		return null;
	}
	public boolean isEmpty() {
		return size==0? true : false;
	}

	public Object set(Object key, Object value) {
		if(contains(key)) delete(key);
		
		this.ensureCapacity();
		int hash = Math.abs( String.valueOf(key).hashCode() ) % listMaps.length;
		
		if(listMaps[hash]==null) listMaps[hash] = new ListMap();
		listMaps[hash].set(key, value);
		size++;
		
		return value;
	}
	
	private void ensureCapacity(){
		if(size/listMaps.length>=loadFactor){
			ListMap[] newListMaps = new ListMap[2*listMaps.length];
			for(int i=0;i<listMaps.length;i++){
				newListMaps[i] = listMaps[i];
			}
			listMaps = newListMaps;
		}
	}

	public int size() {
		return size;
	}

	public Iterator iterator() {
		return new HashMapIterator(new ArrayIterator(listMaps));
	}
	
	public Iterator keyIterator(){
		return new HashMapKeyIterator(new ArrayIterator(listMaps));
	}
	
	public Iterator valueIterator(){
		return new HashMapValueIterator(new ArrayIterator(listMaps));
	}
	
	class HashMapIterator implements Iterator{
		private Iterator it;
		private Iterator nit;
		int i;

		public HashMapIterator(Iterator arrayIterator) {
			it = arrayIterator; // arrayIterator of array of ListMaps
			i=0;
		}
		public Object current() throws IteratorOutOfBoundsException {
			if(isDone()) throw new IteratorOutOfBoundsException();
			return nit.current();
		}
		public void first() {
			for(it.first();!it.isDone();it.next() ){
				if(it.current() == null)continue;
				nit = ((ListMap)it.current()).iterator();
				nit.first();
				break;
			}
		}
		public boolean isDone() {
			return size==i ? true : false;
		}
		public void last() {
			for(it.last();!it.isDone();it.previous() ){
				if(it.current() == null)continue;
				nit = ((ListMap)it.current()).iterator();
				nit.first();
				break;
			}
		}
		public void next() {
			nit.next();
			if (nit.isDone()) getNextIt();

			//System.out.println("tuta");
			i++;
		}
		private void getNextIt(){
			for(it.next();!it.isDone();it.next()){
				if (it.current() == null) continue;
				nit = ((ListMap)it.current()).iterator();
				nit.first();
			//	i++;
			//	System.out.println("tuta");
				break;
			}
		}
			public void previous() {
				nit.previous();
				if(nit.isDone()) getPreviousIt();
				i++;
			}
			private void getPreviousIt(){
				for(it.previous();!it.isDone();it.previous()){
					if (it.current() == null) continue;
					nit = ((ListMap)it.current()).iterator();
					nit.first();
					break;
				}
			//	i++;
		}
	}
	class HashMapKeyIterator extends HashMapIterator{
		public HashMapKeyIterator(Iterator arrayIterator) {
			super(arrayIterator);
		}
		public Object current(){
			return ((Map.Entry)super.current()).getKey();	
		}
	}
	class HashMapValueIterator extends HashMapIterator{
		public HashMapValueIterator(Iterator arrayIterator) {
			super(arrayIterator);
		}
		public Object current(){
			return ((Map.Entry)super.current()).getValue();	
		}
	}
}

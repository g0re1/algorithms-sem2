package lesson10.hash;

import lesson1.Iterator;
import lesson1.IteratorOutOfBoundsException;
import lesson2.ArrayList;
import lesson2.List;
import lesson1.Iterable;

public class BucketingHashTable implements HashTable,Iterable {
	private List[] valList;
	private int size;
	private float loadFactor;
	
	public BucketingHashTable(int capacity,float loadFactor) {
		valList = new List[capacity];
		size=0;
		this.loadFactor = loadFactor;
	}
	
	public static void main(String[] args){
		BucketingHashTable hash = new BucketingHashTable(100,0.75f);
		for(int i=0; i<15;i++){
			hash.add(String.valueOf(i));
		}	
		
		for(int i=15; i<30;i++){
			hash.add(String.valueOf(i));
		}	
		
		for(int i=0;i<hash.size();i++){
		   System.out.println( hash.contains(String.valueOf(i)) );
		}
		
		Iterator it = hash.iterator();
		it.last();
		while(!it.isDone()){
			System.out.println(it.current());
			it.previous();
		}
		
	//	hash.show();
	}
	
	public void show(){
		for(int i=0;i<valList.length;i++){
			if(valList[i]==null) continue;
			
			Iterator it =valList[i].iterator();
			it.first();
			while(!it.isDone()){
				System.out.println( it.current() );
				it.next();
			}
		}
	}

	public void add(Object value) {
		assert value != null :"Value cannot be null";
		if(contains(value)) return;
		
		this.ensureCapacity();
		
		String val = String.valueOf(value);
		int hash = Math.abs(val.hashCode()) % valList.length;
		
		if(valList[hash] == null) valList[hash] = new ArrayList();
		
		valList[hash].add((value));
		size++;
	}
	
	private void ensureCapacity(){
		if(size/valList.length>=loadFactor){
			List[] newValList = new List[findNextFirstNumber(valList.length)];
			for(int i=0;i<valList.length;i++){
				newValList[i] = valList[i];
			}
			valList = newValList;
		}
	}
	/*
	 * Returns true if number is FirstNumber and is greater than 10 
	 *  It's pointless to resize hashTable less than size=10
	 */
	
	private static int findNextFirstNumber(int number){
		
		int x = number+1;
		while(!isFirstNumber(x)){
			x++;
		}
		return x;
	}
	
	private static boolean isFirstNumber(int number){
		if(number <10) return false;

		for( int i = number/2;i>2;i--){
			if(number % i == 0) return false;
		}
		return true;
	}
	public boolean contains(Object value) {
		//String val = String.valueOf(value);
		
		for(int i=0;i<valList.length;i++){
			if (valList[i] == null) continue;
			Iterator it =valList[i].iterator();
			it.first();
			while(!it.isDone()){
				if(it.current().equals(value)) return true;
				it.next();
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public Iterator iterator() {
		return new HashIterator();
	}
	
	 final class HashIterator implements Iterator{
		private Iterator it;
		private int i;
		private int itc; // Iterator Counter
		
		public HashIterator(){
			i=0;
		}
		
		public Object current() throws IteratorOutOfBoundsException {
			if( isDone() ) throw new IteratorOutOfBoundsException();
			return it.current();
			
		}
		public void first() {
			for( itc=0;itc < valList.length;itc++){
				if (valList[itc] == null) continue;
				it = valList[itc].iterator();
				it.first();
				break;
			}
	//		i++;
		}
		public boolean isDone() {
			return size() == i ? true : false;
		}
		public void last() {
			for(itc=valList.length-1;itc>-1;itc--){
				if (valList[itc] == null) continue;
				it = valList[itc].iterator();
				it.first();
				break;
			}
		//	i++;
		}
		public void next() {
			it.next();
			if (it.isDone()) getNextIt();

			//System.out.println("tuta");
			i++;
		}
		
		private void getNextIt(){
			for( itc = itc+1; itc<valList.length ; itc++){
				if (valList[itc] == null) continue;
				it = valList[itc].iterator();
				it.first();
			//	i++;
			//	System.out.println("tuta");
				break;
			}
		}

		public void previous() {
			it.previous();
			if(it.isDone()) getPreviousIt();
			i++;
		}
		
		private void getPreviousIt(){
			for(itc=itc-1;itc>-1;itc--){
				if (valList[itc] == null) continue;
				it = valList[itc].iterator();
				it.first();
				break;
			}
		//	i++;
		}
	}
}

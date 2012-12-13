package lesson12.map.exercise;

import lesson1.Iterator;
import lesson11.set.Set;
import lesson12.map.HashMap;
import lesson12.map.Map;

public class SetWithMapsAsDataStorage implements Set {
	private HashMap map;
	private int i;
	
	public static void main(String[] args){
		Set set = new SetWithMapsAsDataStorage();
		set.add("Jarek");
		set.add("Czarek");
		set.add("Arek");
		
		set.delete("Arek");

		
	//	System.out.println( set.toString() );
			
		Iterator it = set.iterator();
		
		it.first();
		while(!it.isDone()){
			System.out.println( it.current() );
			it.next();
		}
	}
	
	public SetWithMapsAsDataStorage(){
		clear();
	}
	
	public String toString(){
		return map.show();
	}
	
	public boolean add(Object value) {
		assert value != null :"value cannot be null";
		if(contains(value)) return false;
		i++;
		return  map.set(i, value) != null ? true : false;
	}

	public void clear() {
		this.map = new HashMap();
		i=-1;
	}

	public boolean contains(Object value) {
		Iterator it = this.hashMapIterator();
		it.first();
		while(!it.isDone()){
			if( ((Map.Entry)it.current()).getValue() == value) return true;
			it.next();
		}
		return false;
	}

	public boolean delete(Object value) {
		assert value != null :"value cannot be null";
		Iterator it = this.hashMapIterator();
		it.first();
		while(!it.isDone()){
			Map.Entry current = (Map.Entry)it.current();
			if( ( current.getValue() == value)){
				map.delete(current.getKey());
				i++;
				return true;
			}
			it.next();
		}
		return false;
	}
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public int size() {
		return map.size();
	}
	
	public Iterator hashMapIterator(){
		return map.iterator();
	}
	
	public Iterator iterator() {
		return map.valueIterator();
	}
}

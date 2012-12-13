package lesson12.map;

import lesson1.Iterator;
import lesson2.ArrayList;
import lesson2.List;

public class ListMap implements Map {
	private List list;
	
	public ListMap(){
		clear();
	}
	public void clear() {
		list = new ArrayList();
	}
	
	public String toString(){
		Iterator it = this.iterator();
		it.first();
		String s="[ ";
		while(!it.isDone()){
			s+=it.current() + ", ";
			it.next();
		}
		return s+=" ]";
	}
	
	public static void main(String[] args){
		Map map = new ListMap();
		map.set("Leon", new Integer(1));
		map.set("Stefan", 2);
		DefaultEntry entry1 = new DefaultEntry("Jarek",5);
		
		map.set(entry1.getKey(), entry1.getValue() );
		
		System.out.println(map.get(entry1.getKey()));
		
		Iterator it = map.iterator();
		it.first();
		while(!it.isDone()){
			System.out.println( it.current().toString() );
			it.next();
		}
	}
	
	public boolean contains(Object key) {
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			Map.Entry entry = (Entry)it.current();
			if(entry.getKey() == key) return true;
			
			it.next();
		}
		//unreachable code but method doesn't know it
		return false;
	}
	
	public Object get(Object key) {
		if(!contains(key)) return null;
		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			Map.Entry entry = (Entry)it.current();
			if(entry.getKey() == key)return entry.getValue() ;
			it.next();
		}
		//unreachable code but method doesn't know it
		return null;
	}
	
	public Object delete(Object key) {		
		Iterator it = list.iterator();
		it.first();
		while(!it.isDone()){
			Map.Entry entry = (Entry)it.current();
			if(entry.getKey() == key){
				list.delete(it.current()) ;
				return entry.getValue();
			}
			it.next();
		}
		return null;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Object set(Object key, Object value) {
		if(contains(key)) this.delete(key);
		
		Map.Entry entry = new DefaultEntry(key,value);
		list.add(entry);
		return value;
	}

	public int size() {
		return list.size();
	}

	public Iterator iterator() {
		return list.iterator();
	}

}

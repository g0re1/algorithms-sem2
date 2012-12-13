package lesson11.set.exercise;

import lesson11.set.HashSet;
import lesson11.set.Set;

public class EmptySet extends HashSet {
	public static void main(String[] args){
		Set set = new EmptySet();
		set.add("A");
	}
	
	public boolean add(Object value){
		throw new UnsupportedOperationException();
	}
}

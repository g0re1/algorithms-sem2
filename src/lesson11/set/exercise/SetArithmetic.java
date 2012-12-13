package lesson11.set.exercise;

import lesson1.Iterator;
import lesson11.set.HashSet;
import lesson11.set.Set;

public class SetArithmetic {
	public static void main(String[] args){
		Set set1 = new HashSet();
		Set set2 = new HashSet();
		
		set1.add("A");
		set1.add("C");
		
		set2.add("B");
		set2.add("C");
		
		Set set3 = setDiff(set1,set2);
		
		System.out.println(set3.toString());
	}
	
	public static Set setDiff(Set set1, Set set2){
		
		Iterator it1 = set1.iterator();
		it1.first();
		
		Set set3 = new HashSet();
		
		while(!it1.isDone()){
			if(!set2.contains(it1.current())) set3.add(it1.current());
			it1.next();
		}
		
		return set3;
	}
	
	public static Set setMultiple(Set set1, Set set2){
		
		Iterator it2 = set2.iterator();
		it2.first();
		
		Set set3 = new HashSet();
		
		while(!it2.isDone()){
			if(set1.contains(it2.current()) )set3.add(it2.current());
			it2.next();
		}
		
		return set3;
	}
	
	public static Set setAdd(Set set1, Set set2){
		
		Iterator it2 = set2.iterator();
		
		it2.first();
		while(!it2.isDone()){
			set1.add(it2.current());
			it2.next();
		}
		return set1;
	}
}

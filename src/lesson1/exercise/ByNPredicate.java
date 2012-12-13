package lesson1.exercise;

import lesson1.ArrayIterator;
import lesson1.Iterator;
import lesson1.Predicate;

public class ByNPredicate implements Predicate {
		private Iterator defIterator; // default Iterator
		private boolean result;
		int byN;// by N iterate
		
		public static void main(String[] args){
		}
		
		public ByNPredicate(Iterator it,int n){
			byN = n;
			defIterator = it;
			defIterator.first();
			byNiterate(byN-1);
			
		}
		
		public void byNiterate(int n){
			assert n>-1 : "argument musi byc dodatni";
			for(int i=n; i>0; i--){
				if(!defIterator.isDone() ) defIterator.next();
			}
		}
		
		public boolean evaluate(Object object) {
			result = false;
			if(!defIterator.isDone()) {
				result = ( defIterator.current() == object );
			}
			if (result) byNiterate(byN);
			return result;
		}
	}


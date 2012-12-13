package lesson1;

public class StupidPredicate implements Predicate{
	private boolean result=true;
	
	public boolean evaluate(Object ob){
		return result;
	}

}

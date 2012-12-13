package lesson6.comparator;

import lesson5.Comparator;

public class FixedComparator implements Comparator{
	private final int result;
	
	public FixedComparator(int result){
		this.result = result;
	}
	
	public int compare(Object left, Object right) throws ClassCastException {
		return result;
	}

}

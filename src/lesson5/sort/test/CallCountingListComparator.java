package lesson5.sort.test;

import lesson5.Comparator;

public final class CallCountingListComparator implements Comparator {
	private Comparator comparator;
	private int CallCount;
	
	public CallCountingListComparator(Comparator comp){
		this.comparator = comp;
		CallCount=0;
	}
	
	public int compare(Object left, Object right) throws ClassCastException {
		CallCount++;
		return comparator.compare(left, right);
	}
	
	public int getCallCount(){
		return CallCount;
	}

}

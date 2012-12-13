package lesson5.sort.test;

import lesson5.Comparator;

public class LowerCaseComparator implements Comparator {
	
	public static final LowerCaseComparator INSTANCE = new LowerCaseComparator(); 

	public int compare(Object left, Object right) throws ClassCastException {
		if( !( (left instanceof String) && (right instanceof String) ) ) throw new ClassCastException();
		String sLeft = (String) left;
		String sRight = (String) right;
		sLeft = sLeft.toLowerCase();
		sRight = sRight.toLowerCase();
		
		return sLeft.compareTo(sRight);
	}

}

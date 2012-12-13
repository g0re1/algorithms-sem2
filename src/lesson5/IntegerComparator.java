package lesson5;

public class IntegerComparator implements Comparator {

	public final static IntegerComparator INSTANCE = new IntegerComparator();
	
	private IntegerComparator(){};
	
	public int compare(Object left, Object right) throws ClassCastException {
		if(!( (left instanceof Integer) && (right instanceof Integer) ) ) throw new ClassCastException();
		
		int newLeft = (Integer) left;
		int newRight = (Integer)right;
		if(newLeft < newRight) return 1;
		if(newLeft > newRight) return -1;
		
		return 0;
	}

}

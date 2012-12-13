package lesson5;

public class ReverseComparator implements Comparator {

	private final Comparator comparator;
	
	public ReverseComparator(Comparator comparator){
		this.comparator = comparator;
	}
	
	public int compare(Object left, Object right)throws ClassCastException {
		return comparator.compare(right, left);
	}
	
}

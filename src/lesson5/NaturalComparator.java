package lesson5;
import java.lang.Comparable;

public class NaturalComparator implements Comparator {

	public final static NaturalComparator INSTANCE = new NaturalComparator();
	
	private NaturalComparator(){};
	
	public int compare(Object left, Object right) throws ClassCastException{
		assert left != null : "Nie określono lewego obiektu";
		return ((Comparable)left).compareTo(right);

	}
	
}

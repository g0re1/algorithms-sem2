package lesson6.comparator;

import junit.framework.TestCase;

public class CompoundComparatorTest extends TestCase{
	
	public void testComparisionContinueWhileEqual(){
		CompoundComparator comparator = new CompoundComparator();
		
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		
		assertSame ( comparator.compare("NIEISTOTNY", "NIEISTOTNY"), 0 );
	}
	
	public void testComparisionEqualAndWorst(){
		CompoundComparator comparator = new CompoundComparator();
		
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(-57));
		comparator.add(new FixedComparator(0));
		
		assertTrue ( comparator.compare("NIEISTOTNY", "NIEISTOTNY") < 0  );
	}
	public void testComparisionEqualAndBetter(){
		CompoundComparator comparator = new CompoundComparator();
		
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(57));
		comparator.add(new FixedComparator(0));
		
		assertTrue ( comparator.compare("NIEISTOTNY", "NIEISTOTNY") > 0  );
	}
}

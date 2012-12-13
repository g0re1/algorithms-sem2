package lesson5;

import junit.framework.TestCase;

public class NaturalComparatorTest extends TestCase{

	public void testLessThanOther(){
		assertTrue( NaturalComparator.INSTANCE.compare("A" ,"B") < 0 );
	}

	public void testEqualToOther(){
		assertTrue( NaturalComparator.INSTANCE.compare("B" ,"B") == 0 );
	}
	
	public void testGreaterThanOther(){
		assertTrue( NaturalComparator.INSTANCE.compare("B" ,"A") > 0 );
	}


}
